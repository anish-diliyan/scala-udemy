@echo off
set BASE_DIR=%~dp0
set PGDATA=%BASE_DIR%data
set PATH=%BASE_DIR%installer\bin;%PATH%

echo Checking PostgreSQL status...

pg_ctl.exe status -D "%PGDATA%"
if errorlevel 1 (
    echo PostgreSQL is NOT running
) else (
    echo PostgreSQL is running

    REM Show more details about the running instance
    psql -U postgres -c "SELECT version();"
    psql -U postgres -c "SELECT pg_postmaster_start_time();"
    psql -U postgres -c "SELECT datname, usename, client_addr, state FROM pg_stat_activity;"
)
pause
