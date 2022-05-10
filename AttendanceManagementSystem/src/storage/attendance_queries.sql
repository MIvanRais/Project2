-- ALTER TABLE admins MODIFY password VARCHAR(15) NOT NULL;
--**create database statement
CREATE DATABASE attendance_db;

--**use statement
USE attendance_db;

--**create table admins
CREATE TABLE admins(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30),
    password VARCHAR(15),
    registration_date DATE DEFAULT (CURRENT_DATE())
);

--**create table users
CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(15) NOT NULL,
    registration_date DATE DEFAULT (CURRENT_DATE())
);