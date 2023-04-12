-- noinspection SqlNoDataSourceInspectionForFile
SELECT 'CREATE DATABASE market-place'
    WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'market-place')\gexec