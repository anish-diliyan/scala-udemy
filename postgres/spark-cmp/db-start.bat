@echo off
setlocal EnableDelayedExpansion

:: PostgreSQL binary path and configuration
set "BASE_DIR=D:\installed\postgres"
set "PG_BIN=%BASE_DIR%\installer\bin"
set "PGDATA=%BASE_DIR%\data"
set "PGLOGS=%BASE_DIR%\logs"
set "PSQL=%PG_BIN%\psql.exe"
set "PG_CTL=%PG_BIN%\pg_ctl.exe"

:: Database configuration
set "DB_NAME=restr_transform_out_pp"
set "DB_USER=postgres"

echo Checking PostgreSQL server status...

:: Check if PostgreSQL server is running
"%PG_CTL%" status -D "%PGDATA%" >nul 2>&1
if !errorlevel! neq 0 (
    echo PostgreSQL server is not running. Starting server...
    "%PG_CTL%" start -D "%PGDATA%" -l "%PGLOGS%\postgresql.log" -w
    if !errorlevel! neq 0 (
        echo ERROR: Failed to start PostgreSQL server
        echo Check the log file at: %PGLOGS%\postgresql.log
        exit /b 1
    )
    echo PostgreSQL server started successfully
    :: Wait for server to be ready
    timeout /t 3 /nobreak >nul
) else (
    echo PostgreSQL server is already running
)

:: Test database connection
echo Testing database connection...
"%PSQL%" -U %DB_USER% -d postgres -c "\q" >nul 2>&1
if !errorlevel! neq 0 (
    echo ERROR: Cannot connect to PostgreSQL server
    echo Please check if:
    echo 1. PostgreSQL service is running
    echo 2. Port 5432 is not blocked
    echo 3. pg_hba.conf is configured correctly
    exit /b 1
)

exit /b 0
