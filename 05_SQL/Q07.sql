use sqldb;

select *
from buytbl;

select *
from usertbl;

-- 1번
select *
from usertbl as u
	inner join buytbl as b
    on u.userID = b.userID;
    
select *
from usertbl as u
	inner join buytbl as b
    on u.userID = b.userID
where u.userID = 'JYP';

-- 2번
select u.userID, u.name, b.prodName, u.addr, concat(u.mobile1, u.mobile2) as mobile
from usertbl as u
	left outer join buytbl as b
    on u.userID = b.userID
order by userID asc;

-- 3번
select *
from usertbl u1
where u1.mobile2 is not null;

select *
from usertbl
where name in (select name from usertbl where mobile2 is not null);

select *
from usertbl u
where u.mobile2 is null;

-- ------------------------------------------------
-- LV02
use sqldb;
create table stdtbl (
	stdNAme VARCHAR(10) not null primary key,
    addr CHAR(4) not null
);

create table clubtbl (
	clubName VARCHAR(10) not null primary key,
    roomNo CHAR(4) not null
);

create table std_club_tbl (
	num int AUTO_INCREMENT not null primary key,
    stdName VARCHAR(10) not null,
    clubName VARCHAR(10) not null,
    foreign key(stdName) references stdtbl(stdName),
    foreign key(clubName) references clubtbl(clubName)
);

show tables;

insert into stdtbl values 
	('김범수', '경남'), ('성시경', '서울'), ('조용필','경기'), ('은지원','경북'), ('바비킴','서울');
    
insert into clubtbl values
	('수영', '101호'), 
    ('바둑', '102호'), 
    ('축구', '103호'), 
    ('봉사', '104호');
    
insert into std_club_tbl values
	(NULL, '김범수', '바둑'),
    (NULL, '김범수', '축구'),
    (NULL, '조용필', '축구'),
    (NULL, '은지원', '축구'),
    (NULL, '은지원', '봉사'),
    (NULL, '바비킴', '봉사');


USE sqldb;

CREATE TABLE stdtbl (
    stdName VARCHAR(10) NOT NULL PRIMARY KEY,
    addr CHAR(4) NOT NULL
);

CREATE TABLE clubtbl (
    clubName VARCHAR(10) NOT NULL PRIMARY KEY,
    roomNo CHAR(4) NOT NULL
);

CREATE TABLE stdclubtbl (
    num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    stdName VARCHAR(10) NOT NULL,
    clubName VARCHAR(10) NOT NULL,
    FOREIGN KEY (stdName) REFERENCES stdtbl(stdName),
    FOREIGN KEY (clubName) REFERENCES clubtbl(clubName)
);
