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

--**database cloning
CREATE DATABASE clone_db;

USE clone_db;

CREATE TABLE admins(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(30) UNIQUE,
    password VARCHAR(15),
    registration_date DATE DEFAULT (CURRENT_DATE())
);

CREATE TABLE admin_details(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    gender VARCHAR(6),
    no_telephone CHAR(10),
    email VARCHAR(30),
    admin_username VARCHAR(30),
    FOREIGN KEY(admin_username) REFERENCES admins(username)
);

CREATE TRIGGER tr_admins_ai AFTER INSERT ON admins FOR EACH ROW
INSERT INTO admin_details (admin_username) values (new.username);

UPDATE admin_details SET first_name = 'Udin', last_name = 'uhuy', gender = 'male', no_telephone = '21212324', email = 'udin@gmail.com' WHERE admin_username = 'admin';