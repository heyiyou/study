USE my_cat;

CREATE TABLE member (
   s_id char(50) primary key,
    s_pw char(50) not null
    );
INSERT INTO member (id, pw ) VALUES ('e8576', 'tjslas8576');
INSERT INTO member (id, pw) VALUES ('admin', '1234');
show tables; 



SELECT * FROM member ;
DESC  member;





DROP TABLE  member;
