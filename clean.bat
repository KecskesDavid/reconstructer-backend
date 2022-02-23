echo off

chcp 1250

rem clean application
call mvnw -Dmaven.wagon.http.ssl.insecure=true -P hibernate clean

rem drop database
if "x%PGPASSWORD%" == "x" (
    set PGPASSWORD=kecskes
)
"C:\Program Files\PostgreSQL\13\bin\psql.exe" -h localhost -U postgres -d postgres -f db/db_00_drop_db.sql
