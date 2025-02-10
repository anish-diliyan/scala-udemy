set BASE_DIR=%~dp0
set PGDATA=%BASE_DIR%data

@echo off
echo Cleaning up PostgreSQL directories...
pg_ctl.exe status -D "%PGDATA%" > nul 2>&1
if not errorlevel 1 (
    echo Stopping PostgreSQL server...
    pg_ctl.exe -D "%PGDATA%" stop -m fast
    timeout /t 5
)

echo Deleting existing data and logs directories...
if exist %BASE_DIR%data rmdir /s /q %BASE_DIR%data
if exist %BASE_DIR%logs rmdir /s /q %BASE_DIR%logs
timeout /t 5

@echo off
echo Setting up PostgreSQL environment and employees database...

mkdir %BASE_DIR%data
mkdir %BASE_DIR%logs

REM Set environment variables
REM If your batch file is located at D:\learning\spark-udemy\postgres\db-setup.bat, then:
REM %~dp0 expands to D:\learning\spark-udemy\postgres\
set PGDATA=%BASE_DIR%data
set PGDATABASE=postgres
set PGUSER=postgres
set PGPORT=5432
set PGLOGS=%BASE_DIR%logs
set SQLPATH=%BASE_DIR%sql

REM Add PostgreSQL bin directory to PATH
set PATH=%BASE_DIR%installer\bin;%PATH%

if not exist "%PGDATA%\postgresql.conf" (
    echo Initializing database cluster...
    initdb.exe -D "%PGDATA%" -U postgres -E UTF8 -A trust
)

echo Starting PostgreSQL server...
pg_ctl.exe -D "%PGDATA%" -l "%PGLOGS%\postgresql.log" start -w

timeout /t 5

echo Creating employees database...
createdb -U postgres employees

timeout /t 5

echo Loading employees database...
psql -U postgres -d employees -f "%SQLPATH%\employees_db.sql"

if errorlevel 1 (
    echo Error loading database schema
    exit /b 1
)

echo Setup completed successfully!
echo You can connect to the database using: psql -U postgres -d employees
pause