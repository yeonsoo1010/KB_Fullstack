-- 1번
show databases;

use employees;
show tables;

-- employees 데이터베이스의 테이블 목록 보기 ( views 제외 )
show full tables where Table_Type != 'VIEW';

-- employees 테이블의 열(column) 목록 출력하기
show columns from employees;

-- -------------
-- 2번
use employees;
select * from titles;

select first_name from employees;

select first_name, last_name, gender from employees;

-- -------------
-- 3번
use employees;
select first_name as 이름, gender as 성별, hire_date as '회사 입사일'
from employees;

-- -------------
-- 5번
use sqldb;
select *
from usertbl
where name = '김경호';

select *
from usertbl
where birthYear >= 1970 and height >=182;

-- ------------
-- 6번
use sqldb;
select *
from usertbl
where height between 180 and 183;

select *
from usertbl
where addr in ('경남', '전남', '경북');

select *
from usertbl
where name like '김%';

-- ---------------
-- 7번
use sqldb;
select name, height
from usertbl
where height > (select height from usertbl where name = '김경호');

-- ----------------
-- 8번
select *
from usertbl
order by mDate;

select *
from usertbl
order by mDate desc;

select *
from usertbl
order by height desc, name desc;

-- ------------
-- 9번
select distinct addr
from usertbl
order by addr;