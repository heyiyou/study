use my_cat;
CREATE TABLE board (
    b_no INT PRIMARY KEY AUTO_INCREMENT,   -- 글 번호 (자동 증가)
    b_title VARCHAR(255) NOT NULL,         -- 글 제목
    b_id CHAR(20) NOT NULL,                -- 작성자 ID
    b_datetime DATETIME NOT NULL,          -- 작성 시간
    b_hit INT DEFAULT 0 NOT NULL,          -- 조회수
    b_text TEXT,                           -- 글 내용
    b_reply_ori INT,                       -- 원글 번호 (댓글이면 어떤 글에 대한 건지)
    b_reply_text TEXT                      -- 댓글 내용 (댓글일 경우 사용)
);

INSERT INTO board (b_title, b_id, b_datetime, b_hit, b_text)
VALUES
('공지사항입니다', 'admin', NOW(), 0, '게시판 사용법을 꼭 읽어주세요.'),
('자기소개입니다', 'user1', NOW(), 0, '안녕하세요. 신입 회원입니다.'),
('오늘 날씨 좋네요', 'user2', NOW(), 0, '산책하기 좋은 날씨예요.'),
('자바 기초 배우기', 'user3', NOW(), 0, '변수, 조건문, 반복문을 공부해요.'),
('SQL INSERT 실습', 'user4', NOW(), 0, '데이터 추가하는 법을 연습합니다.'),
('JDBC 연결 성공', 'user5', NOW(), 0, '자바에서 MySQL 연결 성공!'),
('게시판 기능 구현', 'user6', NOW(), 0, '글쓰기, 읽기 기능을 만들고 있어요.'),
('오라클과 MySQL 차이', 'user7', NOW(), 0, '두 DB의 차이를 정리했습니다.'),
('LIMIT 문법 정복', 'user8', NOW(), 0, '페이지 기능을 만들기 위한 핵심입니다.'),
('프로젝트 마무리 중', 'user9', NOW(), 0, '게시판 구현 거의 끝났습니다.');







select * from board;		
select * from board where b_no>=11 and b_no<21;		
select * from board order by b_no desc;		



DROP TABLE board;           #완전 삭제

show tables;       