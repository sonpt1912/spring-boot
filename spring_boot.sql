CREATE DATABASE Spring_Boot

CREATE TABLE Spring_Boot.Employee
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(50),
    Age INT,
    Salary DECIMAL
)

CREATE TABLE Spring_Boot.Class
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(20)
)

CREATE TABLE Spring_Boot.Student
(
	Id INT AUTO_INCREMENT PRIMARY KEY,
    Name NVARCHAR(50),
    Age INT,
    Class_id INT,
	constraint fk_sl foreign key (Class_id) references Class(Id) 
)

