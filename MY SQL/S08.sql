#[1.🛠️ SELECT 기본 특훈]
use my_cat;

-- 문제 1	모든 도시의 이름을 조회하라.	
		SELECT 도시명
		FROM 도시;
		
-- 문제 2	모든 항해사의 이름과 직급을 조회하라.	
		SELECT 항해사명, 직급
		FROM 항해사;
		
-- 문제 3	모든 선박의 이름과 선박 종류를 조회하라.	
		SELECT 선박명, 선박종류
		FROM 선박;
		
-- 문제 4	모든 교역품의 이름과 기준가격을 조회하라.	
		SELECT 교역품명, 기준가격
		FROM 교역품;
-- 문제 5	직급이 '선장'인 항해사의 이름을 조회하라.	
		SELECT 항해사명
		FROM 항해사
		WHERE 직급 = '선장';
-- 문제 6	현재 선원이 50명 이상인 선박의 이름을 조회하라.	
		SELECT 선박명
		FROM 선박
		WHERE 현재선원수 >= 50;
-- 문제 7	기준가격이 1000 이상인 교역품명을 조회하라.	
		SELECT 교역품명
		FROM 교역품
		WHERE 기준가격 >= 1000;
-- 문제 8	리스본'에 소속된 항해사의 이름을 조회하라.	
		SELECT 항해사명
		FROM 항해사
		WHERE 도시ID = (SELECT 도시ID FROM 도시 WHERE 도시명 = '리스본');
-- 문제 9	고양이길드'에 소속된 항해사의 이름을 조회하라.	
		SELECT 항해사명
		FROM 항해사
		WHERE 소속길드ID = (SELECT 길드ID FROM 길드 WHERE 길드명 = '고양이길드');
-- 문제 10	와인'을 구입할 수 있는 도시 이름을 조회하라.	
		SELECT DISTINCT 도시명
		FROM 도시
		JOIN 도시교역품 ON 도시.도시ID = 도시교역품.도시ID
		JOIN 교역품 ON 도시교역품.교역품ID = 교역품.교역품ID
		WHERE 교역품명 = '와인';