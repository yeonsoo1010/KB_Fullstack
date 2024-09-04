use sqldb;
select * from buytbl;

start transaction;
delete from buytbl where num = 1;
delete from buytbl where num = 2;

select * from buytbl;

rollback;

select * from buytbl;

select @@autocommit;
set autocommit = false;

-- ---------------------------

create database jdbc_ex;
create user 'jdbc_ex'@'%' identified by 'jdbc_ex';
grant all privileges on jdbc_ex.* to 'jdbc_ex'@'%';
flush privileges;

