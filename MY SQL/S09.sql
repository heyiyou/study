USE my_cat;
            #길드 테이블

                          #'도시 프로그램'
CREATE TABLE 도시 (
    도시ID INT PRIMARY KEY,                             #조회 하기 위해서 미리 명령어 예를 들어1 번을 지정해서 바로 알수있게
    도시명 VARCHAR(70)
);

INSERT INTO 도시 (도시ID, 도시명) 
VALUES
(1, '리스본'),
(2, '세비야'),
(3, '런던'),
(4, '대한민국'),
(5, '일본');
SELECT * FROM 도시;

DESC 도시;

 

DROP TABLE 도시;

				     	 #'항해사 프로그램'
                
CREATE TABLE 항해사 (
    이름 VARCHAR(100),
    직급 VARCHAR(100)
);
INSERT INTO 항해사
VALUES 
('짱구','선장'),
('철수','일등항해사'),
('맹수','이등항해사'),
('유리','쫄병1'),
('훈이','쫄병2');
SELECT * FROM 항해사;

DROP TABLE 항해사;


		                 #선박의 이름 과 종류 조회 하기

CREATE TABLE 선박 (
   선박ID INT PRIMARY KEY,
    선박명 VARCHAR(50),
    선박종류 VARCHAR(20),
    도시ID INT,
    현재선원수 INT,
    최소필요선원수 INT
);
INSERT INTO 선박
VALUES 
(1,'타이타닉호', '유람선',1,900,300),
(2,'커티삭호', '범선',2,30,10),
(3,'브리타닉호', '병원선',3,500,120),
(4,'광무함', '해군 군함',1,200,20),
(5,'양무함', '석탄배',2,20,5);


SELECT * FROM 선박;

DROP TABLE 선박;


                       #교역물품 이름 및 기준 가격
CREATE TABLE 교역품 (
     교역품ID INT PRIMARY KEY,
    교역품명 VARCHAR(50),
    기준가격 INT
);
INSERT INTO 교역품
VALUES 
(1,'자수정',41820),
(2,'사마 은',41340),
(3,'가는 끈',9380),
(4,'등심초',2552),
(5,'유자',39220);
SELECT * FROM 교역품;

DROP TABLE 교역품;


                      # 서장 직급인 사람만 조회 

select * from 항해사 where 직급 = '선장';			
SELECT * FROM 항해사;


					#선원이 50면 이상인 선박 조희 


SELECT * FROM 선박 WHERE 선원 >= 50;


                
                    #10000이상인 교역품 이름 조회
SELECT * FROM 교역품 WHERE 기준가격 >= 10000;




				    #리스본에 소속된 항해사 이름 조회


select * from 도시 where 도시ID = 1;


                     #고양이 길드에 소속된 항해사의 이름을 조회하라



CREATE TABLE 길드 (
    길드ID INT PRIMARY KEY,
    길드명 VARCHAR(50)
 );
 INSERT INTO 길드 (길드ID, 길드명) VALUES
(1, '고양이길드'),
(2, '삼성'),
(3, 'LG');
 
 -- 항해사 테이블에 길드ID 추가
ALTER TABLE 항해사
ADD COLUMN 길드ID INT;

-- 항해사에 길드ID 데이터 입력
UPDATE 항해사 SET 길드ID = 1 WHERE 이름 = '홍길동';
UPDATE 항해사 SET 길드ID = 1 WHERE 이름 = '이영희';
UPDATE 항해사 SET 길드ID = 2 WHERE 이름 = '김철수';

-- 고양이길드 소속 항해사 이름 조회
SELECT * FROM 항해사.이름;
SELECT 항해사.이름
FROM 항해사
JOIN 길드 ON 항해사.길드ID = 길드.길드ID
WHERE 길드.길드명 = '고양이길드';

DROP TABLE 길드;

show tables;  
                               #    UPDATE 수정 용어  select 자리에 넣는것




drop table member; 

show tables;  
