@echo off
setlocal EnableDelayedExpansion

:: PostgreSQL configuration
set "PSQL=D:\installed\postgres\installer\bin\psql.exe"
set "DB_NAME=restr_transform_out_pp"
set "DB_USER=postgres"

:: Check if psql exists
if not exist "%PSQL%" (
    echo ERROR: psql executable not found at: %PSQL%
    exit /b 1
)

echo Connecting to database %DB_NAME%...
"%PSQL%" -U %DB_USER% -d %DB_NAME%

if !errorlevel! neq 0 (
    echo ERROR: Connection failed
    echo Please check if:
    echo 1. PostgreSQL server is running
    echo 2. Database %DB_NAME% exists
    echo 3. User %DB_USER% has proper permissions
    exit /b 1
)

exit /b 0
