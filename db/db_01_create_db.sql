CREATE ROLE stateproject WITH
    LOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    INHERIT
    NOREPLICATION
    CONNECTION LIMIT -1
    PASSWORD 'stateproject';

-- CREATE TABLESPACE stateproject   OWNER stateproject   LOCATION 'C:\Users\grafl\stateproject\tblspc';
-- ALTER TABLESPACE stateproject   OWNER TO stateproject;

CREATE DATABASE stateproject
    WITH 
    OWNER = stateproject
    ENCODING = 'UTF8'
-- 	LC_COLLATE = 'Hungarian_Hungary.1252'
-- 	LC_CTYPE = 'Hungarian_Hungary.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
