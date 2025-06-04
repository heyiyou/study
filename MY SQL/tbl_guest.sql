use my_cat;	


create table tbl_guest(				
	bno int auto_increment primary key,			
	btext text			
);				


insert into tbl_guest (btext) values('개');				
insert into tbl_guest (btext) values('고양이');				

show tables;  


select * from tbl_guest;				


drop table  tbl_guest ;
