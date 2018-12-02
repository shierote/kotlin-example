#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE kotlindemo;
EOSQL

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" kotlindemo <<-EOSQL
    BEGIN;

    create table customer (
        id serial,
        name varchar(50),
        email varchar(50),
        phone_number varchar(50),
        github_name varchar(50),
        twitter_name varchar(50),
        main_org varchar(50),
        sub_org varchar(50)
    );

    insert into customer(name, email, github_name, phone_number, twitter_name, main_org, sub_org) values ('hoge', 'hoge@example.com', 'hoge', 'hoge', 'hoge','hoge','hoge');
    insert into customer(name, email, github_name, phone_number, twitter_name, main_org, sub_org) values ('fuge', 'fuge@example.com', 'hoge', 'hoge', 'hoge','hoge','hoge');
    insert into customer(name, email, github_name, phone_number, twitter_name, main_org, sub_org) values ('piyo', 'piyo@example.com', 'hoge', 'hoge', 'hoge','hoge','hoge');

    COMMIT;
EOSQL
