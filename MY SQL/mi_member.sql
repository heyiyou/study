

use my_cat;	



create table mi_member(
id char(50) primary key,
pw char(50) not null,
name char(50) not null
);
			

INSERT INTO mi_member (id, pw, name) VALUES ('dog', '1234', '개');
INSERT INTO mi_member (id, pw, name) VALUES ('cat', '1234', '고양이');




show tables;  
select * from mi_member;




drop table mi_member ;
