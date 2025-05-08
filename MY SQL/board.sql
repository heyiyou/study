USE my_cat;

show tables;  

CREATE TABLE board (
    b_no INT PRIMARY KEY AUTO_INCREMENT,  -- 글번호
    b_title CHAR(255) NOT NULL,            -- 글제목
    b_id CHAR(100) NOT NULL,               -- 작성자 id
    b_datetime DATETIME NOT NULL,          -- 작성시간
    b_hit INT DEFAULT 0 NOT NULL,           -- 조회수
    b_text TEXT                             -- 글내용
);
INSERT INTO board (b_title, b_id, b_datetime, b_hit, b_text) VALUES
('첫 번째 글', 'admin', NOW(), 0, '첫 번째 글 내용입니다.'),
('두 번째 글', 'user1', NOW(), 0, '두 번째 글 내용입니다.'),
('세 번째 글', 'user2', NOW(), 0, '세 번째 글 내용입니다.');

select * from board;		
select * from board where b_no>=11 and b_no<21;		
select * from board order by b_no desc;		



DROP TABLE board;           #완전 삭제

show tables;       