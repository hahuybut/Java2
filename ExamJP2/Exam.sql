CREATE DATABASE exam;
USE exam;
CREATE TABLE RapChieuPhim(
TenPhim varchar(50),
MaSoPhim int PRIMARY KEY,
ThoiGianKhoiChieu date,
DaoDien varchar(50),
DoDai int
);

INSERT INTO rapchieuphim VALUES ('Doctor Strange',101,'2022/04/05','Sam Raimi','01:26:00');
INSERT INTO rapchieuphim VALUES ('Avatar',102,'2009/12/10','James Cameron','01:60:02');
INSERT INTO rapchieuphim VALUES ('Avengers:EndGame',103,'2019/04/26','Anthony Russo,Joe Russo','03:02:00');