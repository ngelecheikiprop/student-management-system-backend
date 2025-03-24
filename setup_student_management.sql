-- Step 1: Create the Database
CREATE DATABASE StudentManagementDB;
GO

-- Step 2: Use the Database
USE StudentManagementDB;
GO

-- Step 3: Create Users Table
CREATE TABLE Users (
    id INT IDENTITY(1,1) PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL
);
GO

-- Step 4: Create Students Table
CREATE TABLE Students (
    student_id INT IDENTITY(1,1) PRIMARY KEY,
    first_name VARCHAR(8) NOT NULL,
    last_name VARCHAR(8) NOT NULL,
    dob DATE NOT NULL CHECK (dob BETWEEN '2000-01-01' AND '2010-12-31'),
    class VARCHAR(10) CHECK (class IN ('Class1', 'Class2', 'Class3', 'Class4', 'Class5')),
    score INT CHECK (score BETWEEN 55 AND 95), -- Score updated before upload (+5)
    status TINYINT DEFAULT 1 CHECK (status IN (0,1)), -- 0 = Inactive, 1 = Active
    photo_path VARCHAR(255) DEFAULT '' -- Default empty
);
GO
