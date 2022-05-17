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

--**create tr_admins_ai
CREATE TRIGGER tr_admins_ai AFTER INSERT ON admins FOR EACH ROW
INSERT INTO admin_details (admin_username) values (new.username);

--**create admin_details
CREATE TABLE admin_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    gender VARCHAR(6),
    no_telephone VARCHAR(12),
    email VARCHAR(30),
    admin_username VARCHAR(30),
    FOREIGN KEY(admin_username) REFERENCES admins(username)
);

--**create table users
CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) NOT NULL,
    password VARCHAR(15) NOT NULL,
    registration_date DATE DEFAULT (CURRENT_DATE())
);

--**create tr_users_ai
CREATE TRIGGER tr_users_ai AFTER INSERT ON users FOR EACH ROW
INSERT INTO user_details (user_username) values (new.username);

--**create user_details
CREATE TABLE user_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    gender VARCHAR(6),
    no_telephone VARCHAR(12),
    email VARCHAR(30),
    user_username VARCHAR(30),
    FOREIGN KEY(user_username) REFERENCES users(username)
);