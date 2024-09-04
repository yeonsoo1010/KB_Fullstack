-- world.city 테이블에서
-- district가 2개이상인 국가들을 대상으로
-- 국가, district별로 인구수합을 구하기.
-- (국가별 소합계도 표시)

use world;
-- 전체 출력해보기
select * from city;

-- AFG 국가 출력해보기 -> 4개임 -> 2,332,100
select * from city
where countrycode = 'AFG';


-- 국가별로, district랑 같이 출력
select countrycode, district
from city
group by countrycode, district;

-- 국가별, district, 국가별 인구수
select countrycode, district, sum(population)
from city
group by countrycode, district
with rollup; 

-- 국가 별 district 개수
select countrycode, count(district)
from city
group by countrycode;

-- 2개 이상 district인 국가만 출력
select countrycode, count(district)
from city
group by countrycode
having count(district) >= 2;

-- 이건 안됨 !!!!!!
select countrycode, count(district)
from city
where count(district) >= 2 -- 기준이 없어지는 거니까 !! 
group by countrycode;

-- 국가별 district, 국가별 인구수에 !! district 2개 이상만 못 걸러냄.
select countrycode, district, count(district), sum(population)
from city
group by countrycode, district
with rollup;

-- district 2개 이상인 국가들의 총인구수는 출력
select countrycode as 국가, count(district) as 'district 개수', sum(population) as '국가별 인구수'
from city
group by countrycode
having count(district) >= 2
order by countrycode;



-- 답
select countrycode as 국가, district as 행정구역, sum(population) as 총인구수
from city
where countrycode = any(select countrycode
from city
group by countrycode
having count(district) >= 2)
group by countrycode, district
with rollup;

-- 답2
select countrycode as 국가, district as 행정구역, sum(population) as 총인구수
from city
where countrycode in (select countrycode
from city
group by countrycode
having count(district) >= 2)
group by countrycode, district
with rollup;