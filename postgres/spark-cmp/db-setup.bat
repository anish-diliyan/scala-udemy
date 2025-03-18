@echo off
setlocal EnableDelayedExpansion

:: PostgreSQL binary path and configuration
set "BASE_DIR=D:\installed\postgres"
set "PG_BIN=%BASE_DIR%\installer\bin"
set "PGDATA=%BASE_DIR%\data"
set "PGLOGS=%BASE_DIR%\logs"
set "PSQL=%PG_BIN%\psql.exe"
set "CREATEDB=%PG_BIN%\createdb.exe"
set "DROPDB=%PG_BIN%\dropdb.exe"
set "PG_CTL=%PG_BIN%\pg_ctl.exe"
set "INITDB=%PG_BIN%\initdb.exe"

:: Database configuration
set "DB_NAME=restr_transform_out_pp"
set "DB_USER=postgres"
set "DB_SCHEMA_FILE=%SQLPATH%\restr_transform_out_pp_db.sql"

echo PostgreSQL data directory: %PGDATA%
echo PostgreSQL logs directory: %PGLOGS%

echo Cleaning up PostgreSQL directories...

:: Check if PostgreSQL server is running and stop it
"%PG_CTL%" status -D "%PGDATA%" >nul 2>&1
if !errorlevel! equ 0 (
    echo Stopping PostgreSQL server...
    "%PG_CTL%" stop -D "%PGDATA%" -m fast -w
    if !errorlevel! neq 0 (
        echo Failed to stop PostgreSQL server gracefully. Attempting force stop...
        "%PG_CTL%" stop -D "%PGDATA%" -m immediate
        if !errorlevel! neq 0 (
            echo ERROR: Could not stop PostgreSQL server
            exit /b 1
        )
    )
    echo PostgreSQL server stopped successfully
)

echo Deleting existing data and logs directories...
:: Clean up existing directories
if exist "%PGDATA%" (
    rmdir /s /q "%PGDATA%"
)
if exist "%PGLOGS%" (
    rmdir /s /q "%PGLOGS%"
)

:: Create fresh directories
echo Creating new data and logs directories...
mkdir "%PGDATA%" 2>nul
if !errorlevel! neq 0 (
    echo ERROR: Failed to create data directory
    exit /b 1
)

mkdir "%PGLOGS%" 2>nul
if !errorlevel! neq 0 (
    echo ERROR: Failed to create logs directory
    exit /b 1
)

echo Successfully created data and logs directories

:: Initialize new database cluster
echo Initializing new PostgreSQL database cluster...
"%INITDB%" -D "%PGDATA%" -U %DB_USER% --encoding=UTF8 --locale=C
if !errorlevel! neq 0 (
    echo ERROR: Database initialization failed
    exit /b 1
)

:: Start PostgreSQL server
echo Starting PostgreSQL server...
"%PG_CTL%" start -D "%PGDATA%" -l "%PGLOGS%\postgresql.log" -w
if !errorlevel! neq 0 (
    echo ERROR: Failed to start PostgreSQL server
    echo Check the log file at: %PGLOGS%\postgresql.log
    exit /b 1
)
echo PostgreSQL server started successfully

:: Wait for server to be ready
timeout /t 5 /nobreak >nul

:: Test database connection
"%PSQL%" -U %DB_USER% -d postgres -c "\q" >nul 2>&1
if !errorlevel! neq 0 (
    echo ERROR: Cannot connect to PostgreSQL server
    echo Please check if:
    echo 1. PostgreSQL service is running
    echo 2. Port 5432 is not blocked
    echo 3. pg_hba.conf is configured correctly
    exit /b 1
)

:: Create and populate database
echo Creating %DB_NAME% database...
"%CREATEDB%" -U %DB_USER% %DB_NAME%
if !errorlevel! neq 0 (
    echo ERROR: Failed to create database
    exit /b 1
)
echo Database created successfully

if exist "%DB_SCHEMA_FILE%" (
    echo Loading database schema...
    "%PSQL%" -U %DB_USER% -d %DB_NAME% -f "%DB_SCHEMA_FILE%" -v ON_ERROR_STOP=1
    if !errorlevel! neq 0 (
        echo ERROR: Failed to load database schema
        echo Rolling back - dropping database...
        "%DROPDB%" -U %DB_USER% %DB_NAME%
        exit /b 1
    )
) else (
    echo WARNING: Schema file not found at: %DB_SCHEMA_FILE%
    echo Database created but schema not loaded
)

echo.
echo ========================================
echo Setup completed successfully!
echo.
echo Connection details:
echo   Database: %DB_NAME%
echo   User:     %DB_USER%
echo   Command:  "%PSQL%" -U %DB_USER% -d %DB_NAME%
echo ========================================
echo.

choice /c YN /m "Press Y to connect to database now, N to exit"
if !errorlevel! equ 1 (
    "%PSQL%" -U %DB_USER% -d %DB_NAME%
)

exit /b 0
