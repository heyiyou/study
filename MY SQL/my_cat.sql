use my_cat;

select * from cat_board;
create table cat_board(
	num int primary key auto_increment, 
    title char(255),
    content text,
    id char(30)
);

insert into cat_board values(0,'롤','PC리그오브레전드, PC+휴대폰 롤토체스 ','어이you');
insert into cat_board values(0,'스팀','발로란트 - FPS배틀게임  , 배그 - FPS 전략 배틀게임 ','haiyiyou');
insert into cat_board values(0,'넥슨','카트라이더 - 현재 서버 종료, 서든어택 - FPS 총게임  ','속겜you');
insert into cat_board values(0,'한게임','피앙 - 맞고 , 레이시티 - 차 게임 ','you god');

show tables;  



drop table cat_board;