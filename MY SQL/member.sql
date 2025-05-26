use my_cat;

select * from member;

CREATE TABLE member (
    s_id VARCHAR(50) PRIMARY KEY,   -- 사용자 ID
    s_pw VARCHAR(100) NOT NULL      -- 사용자 비밀번호
);
desc member;

INSERT INTO member (s_id, s_pw) VALUES ('testuser', '1234');
INSERT INTO member (s_id, s_pw) VALUES ('www', 'eeee');


show tables;  

drop table member;
