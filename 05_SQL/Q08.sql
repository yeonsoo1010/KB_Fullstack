drop database if exists tabledb;
create database tabledb;

drop table if exists usertbl;
create table usertbl (
	userID CHAR(8) not null primary key,
    name VARCHAR(10) not null,
    birthyear int not null,
    addr CHAR(2) not null,
    mobile1 CHAR(3),
    mobile2 CHAR(8),
    height smallint,
    mDate DATE
);

create table buytbl (
	num int AUTO_INCREASE not null primary key,
    userID CHAR(8) not null,
    
)