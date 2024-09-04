SELECT * FROM employees.employees;


use employees;
create table users (select first_name as name, gender from employees);

select * from users;


use world;
create table KoreaCity
(select id, name, district from city
where countrycode = 'kor');



-- city 테이블로 국가 별 총 인구수
select countrycode as 국가, sum(population) as 총인구수
from city
group by countrycode
order by sum(population) desc;