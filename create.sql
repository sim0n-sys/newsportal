CREATE DATABASE organization_api;
\c organization_api
CREATE TABLE news(id serial PRIMARY KEY, header VARCHAR, newsContent VARCHAR, writer VARCHAR, departmentId int);
CREATE TABLE departments_users(id serial PRIMARY KEY, departmentId int, usersId int);
CREATE TABLE users(id serial PRIMARY KEY, userName VARCHAR, position VARCHAR, departmentId int);