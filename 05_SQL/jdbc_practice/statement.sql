create database shop;

use shop;
CREATE TABLE member (
                        id VARCHAR(10) PRIMARY KEY,
                        password VARCHAR(255),
                        name VARCHAR(255),
                        tel VARCHAR(255)
);

select * from member;
delete from member
where id = "ys";
select * from member;