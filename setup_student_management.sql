CREATE DATABASE StudentManagementDB;
GO

USE StudentManagementDB;
GO

CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);
GO

CREATE TABLE Students (
    student_id INT IDENTITY(1,1) PRIMARY KEY,
    first_name VARCHAR(8) NOT NULL,
    last_name VARCHAR(8) NOT NULL,
    dob DATE NOT NULL,
    class VARCHAR(10) CHECK (class IN ('Class1', 'Class2', 'Class3', 'Class4', 'Class5', 'Class6', 'Class7', 'Class8')),
    score INT, 
    status TINYINT DEFAULT 1 CHECK (status IN (0,1)), 
    photo_path VARCHAR(255) DEFAULT ''
);
GO
