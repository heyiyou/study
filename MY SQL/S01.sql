use my_cat;

create table visit_count(	#테이블 만들기. 칼럼(또는 필드 또는 열이름)은 딸랑 한개.
	count int
);
drop table visit_count;            #완전 삭제

show tables;                     #보여줘
  
select * from visit_count;            #모든 데이터를 조회
  
insert into visit_count values(0);	#데이터를 한 줄 넣기

update visit_count set count=count+1;        #이건 뭐(count)1개를 늘린다 

delete from 테이블 이름;                 #모든 테이터를 삭제  테이블은 남기고

select * from board order by b_no desc;  #보여줘


-- 명령어	역할                            중요
-- USE	사용할 데이터베이스 선택
-- CREATE TABLE	테이블 생성
-- DROP TABLE	테이블 완전 삭제
-- SHOW TABLES	데이터베이스 안 테이블 확인
-- SELECT *	테이블 전체 조회
-- INSERT	데이터 삽입
-- UPDATE	데이터 수정 (count 증가 등)
-- DELETE	데이터 삭제 (테이블 구조는 유지)