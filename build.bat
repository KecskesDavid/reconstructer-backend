@echo off

rem create the database and load the initial data
if "x%PGPASSWORD%" == "x" (
    set PGPASSWORD=kecskes
)
"C:\Program Files\PostgreSQL\13\bin\psql.exe" -h localhost -U postgres -d postgres -f db/db_01_create_db.sql
"C:\Program Files\PostgreSQL\13\bin\psql.exe" -h localhost -U postgres -d postgres -f db/db_02_create_tables.sql
"C:\Program Files\PostgreSQL\13\bin\psql.exe" -h localhost -U postgres -d postgres -f db/db_03_create_sequencies.sql
"C:\Program Files\PostgreSQL\13\bin\psql.exe" -h localhost -U postgres -d postgres -f db/db_04_create_views.sql
"C:\Program Files\PostgreSQL\13\bin\psql.exe" -h localhost -U postgres -d postgres -f db/db_99_inserts.sql

rem https://stackoverflow.com/questions/21252800/how-to-tell-maven-to-disregard-ssl-errors-and-trusting-all-certs
rem install the application
call mvnw -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true -DskipTests=true -P hibernate install
    