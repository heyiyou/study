USE my_cat;

show tables;  

            # 새로운 항해사
CREATE TABLE 새로운항해사 (
    항해사ID INT,  
	항해사명 VARCHAR(50),
    직급 VARCHAR(20),
    소속길드ID INT,
    도시ID INT
);

INSERT INTO 새로운항해사 (  항해사ID, 항해사명, 직급 , 소속길드ID , 도시ID )
VALUES 
(6,'강항해사', '항해사',1,2);

SELECT * FROM 세로운항해사;
DESC 새로운항해사;


DROP TABLE 새로운항해사;
