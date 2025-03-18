@echo off
set BASE_DIR=%~dp0
set PATH=%BASE_DIR%installer\bin;%PATH%
set PGDATA=%BASE_DIR%data
set PGLOGS=%BASE_DIR%logs

echo Stopping PostgreSQL server...
pg_ctl.exe -D "%PGDATA%" stop -m fast

echo Starting PostgreSQL server...
pg_ctl.exe -D "%PGDATA%" -l "%PGLOGS%\postgresql.log" start -w

echo Connecting to PostgreSQL...
psql -U postgres -d employees

if errorlevel 1 (
    echo Failed to connect to database
    echo Make sure PostgreSQL is running and binaries are in: %BASE_DIR%installer\bin
)
pause

REM -- Useful commands inside psql:
REM \dt                     -- List all tables
REM \d employees           -- Describe employees table
REM SELECT COUNT(*) FROM employees;    -- Count employees
REM \q to quit