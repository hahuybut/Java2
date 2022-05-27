CREATE DATABASE IF NOT EXISTS ebookshop;
USE ebookshop;
DROP TABLE IF EXISTS book;
CREATE TABLE book(
    id int,
    title varchar(50),
    author varchar(50),
    price float,
    qty int,
    PRIMARY KEY (id));

INSERT INTO book VALUES (1001,'Java for dummies','Đặng Kim Thi',11.11,11);
INSERT INTO book VALUES (1002,'More Java for dummies','CodeLean VN',22.22,22);
INSERT INTO book VALUES (1003,'More Java for more dummies','Mohamad Ali',33.33,33);
INSERT INTO book VALUES (1004,'A cup of Java','Kumar',44.44,44);
INSERT INTO book VALUES (1005,'Java for dummies','Đặng Kim Thi',55.55,55);

//ex1://
SELECT * FROM book;
SELECT title,price FROM book WHERE author = 'CodeLean VN';
SELECT title,author,price,qty FROM book WHERE author = 'CodeLean VN' OR price >=30 ORDER BY price DESC,id ASC;

//ex2//
SELECT * FROM customers;
SELECT ContactName FROM customers;
SELECT * FROM products;
SELECT * FROM products WHERE  UnitPrice >=10 AND UnitPrice <=20;
SELECT * FROM order;


