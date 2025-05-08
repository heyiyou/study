drop table tottenham_squad;
create table tottenham_squad(                        		
	id int primary key auto_increment,	
		
	p_number int,	
	p_name char(50),	
	p_birth date,	
	p_position char(20),	
	p_height int,	
	p_weight int	
);		
select * from tottenham_squad;                 #보여줘 코드
create database tottenham_squad;	
show databases;	
drop database tottenham_squad;	                 #테이블과 함께 삭제
delete from tottenham_squad;                     # 테이블만 살리고 일부삭제
#공격수					
insert into tottenham_squad values(0,19,'도미닉 솔란케','1997-09-14','공격수',187,80);					
insert into tottenham_squad values(0,22,'브레넌 존슨','2001-05-23','공격수',179,73);					
insert into tottenham_squad values(0,7,'손흥민','1992-07-08','공격수',183,78);					
insert into tottenham_squad values(0,28,'윌슨 오도베르','2004-11-28','공격수',182,77);					
insert into tottenham_squad values(0,16,' 티모 베르너','1996-03-06','공격수',180,75);					
insert into tottenham_squad values(0,9,'히살리송','1997-05-10','공격수',179,71);					
					
					
#미드필더					
insert into tottenham_squad values(0,21,'데얀클루셰프스키','2000-04-25','미드필더',186,75);					
insert into tottenham_squad values(0,30,'로드리고벤탄쿠르','1997-06-26','미드필더',187,77);					
insert into tottenham_squad values(0,15,'루카스 베리발','2006-02-02','미드필더',186,90);					
insert into tottenham_squad values(0,14,'아치 그레이','2006-03-12','미드필더',187,79);					
insert into tottenham_squad values(0,45,'알피 디바인','2004-08-01','미드필더',182,75);					
					
					
insert into tottenham_squad values(0,38,'이브스 비수마','1996-08-30','미드필더',182,72);					
insert into tottenham_squad values(0,10,'제임스 메디슨','1996-11-23','미드필더',175,73);					
insert into tottenham_squad values(0,18,'지오바니 로셀소','1996-04-09','미드필더',177,74);					
insert into tottenham_squad values(0,29,'파페 마타르 사르','2002-09-14','미드필더',184,70);					
					
					
#수비수					
insert into tottenham_squad values(0,13,'데스티니 우도지','2002-11-28','수비수',186,80);					
insert into tottenham_squad values(0,6,'라두 드라구신','2002-02-03','수비수',190,84);					
insert into tottenham_squad values(0,37,'미키 판 더 펜','2001-04-19','수비수',193,81);					
insert into tottenham_squad values(0,33,'벤 데이비스','1993-04-24','수비수',181,76);					
insert into tottenham_squad values(0,65,'알피 도링턴','2005-04-20','수비수',192,86);					
insert into tottenham_squad values(0,35,'애슐리 필립스','2005-06-26','수비수',192,86);					
insert into tottenham_squad values(0,15,'에릭 다이어','1994-01-15','미드필더',188,90);					
insert into tottenham_squad values(0,12,'에메르송 로얄','1999-01-14','수비수',181,79);					
insert into tottenham_squad values(0,17,'크리스티안 로메로','1998-04-27','수비수',185,79);					
insert into tottenham_squad values(0,23,'페드로 포로','1999-09-13','수비수',173,71);					
					
#골키퍼					
insert into tottenham_squad values(0,21,'굴리엘모 비카리오','1996-10-07','골키퍼',188,83);					
insert into tottenham_squad values(0,40,'브랜든 오스틴','1999-01-08','골키퍼',188,80);					
insert into tottenham_squad values(0,41,'알피 화이트맨','1998-10-02','골키퍼',189,84);					
insert into tottenham_squad values(0,1,'위고 요리스','1986-12-26','골키퍼',188,82);					
insert into tottenham_squad values(0,20,'프레이저 포스터','1988-03-17','골키퍼',201,93);			

-- select * from tottenham_squad where p_position = '공격수';                              #공격수만 보이게 하기
-- delete from tottenham_squad where p_number = 7;                                       #토트넘 7번 선수만 삭제 코드
-- update tottenham_squad set p_name = '로드리고밴탄쿠르' where p_number=30;                  # 맨뒤에 번호를 넣으면특정번호의 선수 이름 수정
-- select * from tottenham_squad where p_number >= 7;                                     #7번 이상 인 선수들만 출력
-- select * from tottenham_squad where p_name like '%제%' and p_number > 1;                 #번호 6번 이상이면 이름에 제 가 들어간 선수들만 출력




--  ALTER TABLE tottenham_squad ADD weekly_pay int;                              #선수 주급넣는곳을 만든다
-- ALTER TABLE tottenham_squad ADD weekly_pay int default 0;                    #같은거


-- select * from tottenham_squad order by p_number;					
-- select * from tottenham_squad order by p_number asc;					    # 넘버 작은순으로 정렬
-- select * from tottenham_squad order by p_number desc;					


-- select * from tottenham_squad order by p_height desc, p_weight;		   # 몸무게가 가벼운 선수 기준으로 나오게 하는코드 			


-- update tottenham_squad set weekly_pay = 1000 where p_number=9;           #선수들 주급 수정 하는 코드	


-- select * from tottenham_squad order by weekly_pay desc;           #주급 순으로 정렬


select p_number,p_name from tottenham_squad;					#선수들 등번호 이름만 뽑기
select p_number as 등번호,p_name as 선수명 from tottenham_squad;     # 위에랑 같다