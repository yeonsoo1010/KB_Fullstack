use sakila;

-- film 확인, actor 확인, film_actor 확인
select * from film;
select * from actor;
select * from film_actor; -- actor id, film id, 업데이트(actor)

select a.actor_id, a.first_name, a.last_name, fa.film_id, f.title, f.release_year
from actor a
	inner join film_actor fa
    on a.actor_id = fa.actor_id
    
    inner join film f
    on fa.film_id = f.film_id;