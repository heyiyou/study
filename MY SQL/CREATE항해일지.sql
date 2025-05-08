USE my_cat;
            # 항해일지 테이블
CREATE TABLE 항해일지 (
    일지ID INT PRIMARY KEY,  #조회 하기 위해서 미리 명령어 예를 들어1 번을 지정해서 바로 알수있게
	항해사ID INT,
    출항일자 DATE,
    귀환일자 DATE
);

INSERT INTO 항해일지 (일자ID, 항해사ID, 출항일자, 귀환일자)
VALUES 
(1,412, '2025-03-11','2025-04-24'),
(2,212, '2025-04-25','2025-04-28' );


SELECT * FROM 항해일지;
DESC 항해일지;


DROP TABLE 항해일지;





				     	 #향로 테이블
CREATE TABLE 항로 (
    항로ID INT PRIMARY KEY,  #조회 하기 위해서 미리 명령어 예를 들어1 번을 지정해서 바로 알수있게
	출발도시ID INT,
    도착도시ID INT,
    거리 INT COMMENT '단위 : km'
);


INSERT INTO 항로 (항로ID, 출발도시ID, 도착도시ID, 거리)
VALUES 
(1, 100, 200, 300),
(2, 100, 300, 500);


SELECT * FROM 항로;
DROP TABLE 항해사;


                           #선원 테이블 


CREATE TABLE 선원 (
    선원ID INT PRIMARY KEY,                #조회 하기 위해서 미리 명령어 예를 들어1 번을 지정해서 바로 알수있게
	선원명 VARCHAR(50),
    소속선박ID INT,
    선원직책 VARCHAR(50)
);

INSERT INTO 선원 (선원ID, 선원명, 소속선박ID, 선원직책)
VALUES 
(1,'흰둥이',212,'선장펫'),
(2,'검둥이', 412,'선장펫2');


SELECT * FROM 선원;
DESC 선원;


DROP TABLE 선원;


                                # 무기 테이블

CREATE TABLE 무기 (		
    무기ID INT PRIMARY KEY,		
    무기명 VARCHAR(50),		
    공격력 INT,		
    가격 INT		
);

INSERT INTO 무기 (무기ID, 무기명, 공격력, 가격)
VALUES 
(1, '흰둥소드', 500,10000),
(2, '검둥소드', 350, 8000);


SELECT * FROM 무기;
DESC 무기;


DROP TABLE 무기;




                     #선박 업그레이드 
CREATE TABLE 선박업그레이드(		
업그레이드ID INT PRIMARY KEY,		
선박ID INT,		
업그레이드명 VARCHAR(50),		
업그레이드날짜 DATE		
);		


INSERT INTO 선박업그레이드 (업그레이드ID, 선박ID, 업그레이드명, 업그레이드날짜)
VALUES 
(1, 123, '노아의 방주', '2025-04-24'),
(2, 234, '거북선','2025-04-28');


SELECT * FROM 선박업그레이드;
DESC 선박업그레이드;


DROP TABLE 선박업그레이드;




                          #길드원 테이블
                          
CREATE TABLE 길드원테이블(
길드원ID INT PRIMARY KEY,		
길드ID INT,		
항해사ID INT,		
가입일자 DATE		
);

SELECT * FROM 길드원;
DESC 길드원;

DROP TABLE 길드원;

                           #거래 기록 테이블
CREATE TABLE 거래기록 (
    거래ID INT PRIMARY KEY,
    항해사ID INT,
    교역품ID INT,
    수량 INT,
    거래가격 INT,
    거래일자 DATE
);


INSERT INTO 거래기록 (거래ID, 항해사ID, 교역품ID, 수량, 거래가격, 거래일자)
VALUES 
(1, 101, 201, 5, 10000, '2025-04-20'),
(2, 102, 202, 3, 8000, '2025-04-22');


SELECT * FROM 거래기록;
DESC 거래기록;


DROP TABLE 거래기록;
                     
	
                         # 모험 테이블
                     
CREATE TABLE 모험 (
    모험ID INT PRIMARY KEY,
    항해사ID INT,
    모험명 VARCHAR(100),
    성공여부 BOOLEAN
);

INSERT INTO 모험 (모험ID, 항해사ID, 모험명, 성공여부)
VALUES 
(1, 101, '심해 탐험', TRUE),
(2, 102, '보물찾기', FALSE);


SELECT * FROM 모험;
DESC 모험;


DROP TABLE 모험;

                  
                  
                      # 보물 테이블
CREATE TABLE 보물 (
    보물ID INT PRIMARY KEY,
    보물명 VARCHAR(50),
    가치 INT,
    발견도시ID INT,
    위도 DECIMAL(9,6),
    경도 DECIMAL(9,6)
);


INSERT INTO 보물 (보물ID, 보물명, 가치, 발견도시ID, 위도, 경도)
VALUES 
(1, '잃어버린 왕관', 500000, 100, 35.123456, 129.123456),
(2, '심해의 진주', 300000, 200, 36.654321, 130.654321);


SELECT * FROM 보물;
DESC 보물;


DROP TABLE 보물;
