@echo off
set BASE_DIR=%~dp0
set PGDATA=%BASE_DIR%data
set PATH=%BASE_DIR%installer\bin;%PATH%
echo Stopping PostgreSQL server...
pg_ctl.exe -D "%PGDATA%" stop -m fast
pause
