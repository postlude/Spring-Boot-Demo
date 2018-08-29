SHOW DATABASES;

create database demo;

use demo;

-- 현재 db 확인
SELECT DATABASE();

create table test(
	seq int primary key auto_increment,
    name varchar(30)
);

select * from test;

insert into test(name) values('name2');

commit;