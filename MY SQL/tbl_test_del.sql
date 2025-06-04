use my_cat;	


create table tbl_test_del (				
	no int,			
	str varchar(500)			
);				
insert into tbl_test_del values(1, '개');				
insert into tbl_test_del values(2, '고양이');				
insert into tbl_test_del values(3, '너굴맨');				
				
select * from tbl_test_del ;				



show tables;  

drop table tbl_test_del ;
