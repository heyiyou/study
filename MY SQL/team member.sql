use my_cat;

select * from member;

CREATE TABLE member (
  username VARCHAR(50) NOT NULL UNIQUE,         -- 로그인 ID 
  password VARCHAR(255) NOT NULL,                -- 비밀번호
  name VARCHAR(100),                       -- 이름
  email VARCHAR(100)                       -- 이메일
);

INSERT INTO member (username, password, name, email) VALUES ('hai1234', '1234', '김지운', 'billboy454@gmail.com');

 
 truncate member;	
  
select * from  member;	

drop table  member;	

insert into  member value();