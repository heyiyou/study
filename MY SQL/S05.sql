use my_cat;

create table boards(
    b_no int primary key auto_increment, 	#글번호
	b_title char(255) not null,				#글제목
    b_id char(100) not null,					#작성자id
	b_datetime datetime not null,			#작성시간
    b_hit int default 0 not null,			#조회수    
    b_text text,								#글내용
    b_reply_ori int,						#댓글의 원글 번호
    b_reply_text text						#댓글내용
);

desc boards;
insert into boards (b_title,b_id,b_datetime,b_text,b_reply_ori, b_reply_text) values ('글제목','작성자',now(),'나 지금 나 간다','0','쌍욕을 적음 하하하ㅏㅎ');
select * from boards order by b_no desc;

drop table visit_count;            #완전 삭제
delete from board;

show tables;                     #보여줘
select * from board;
select * from board where b_no=100;
select * from board where not b_title is null;
select * from board where b_reply_ori=100;

drop table board;