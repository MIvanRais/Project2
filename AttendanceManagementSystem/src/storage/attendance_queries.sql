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

--**create table admin_details
CREATE TABLE admin_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(320),
    position CHAR(5) DEFAULT 'admin',
    admin_id INT,
    FOREIGN KEY(admin_id) REFERENCES admins(id)
);

--**create table users
CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(15) NOT NULL,
    registration_date DATE DEFAULT (CURRENT_DATE())
);

--**create table user_details
CREATE TABLE user_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    email VARCHAR(320),
    position VARCHAR(100),
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES users(id)
);