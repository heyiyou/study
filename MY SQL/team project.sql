 USE my_cat;

show tables;  

 
 CREATE TABLE board (
  id INT AUTO_INCREMENT PRIMARY KEY,      -- 글번호
  title VARCHAR(255) NOT NULL,            -- 글제목
  content TEXT, -- 글내용
  writer VARCHAR(50),
  createTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 작성시간
  productId INT                            -- 작성자 id
  
  );
		
INSERT INTO board (title, content,  writer, productId) VALUES
('첫 번째 글', '임마', 'NOW', 0 );
INSERT INTO board (title, content, writer) VALUES ('테스트 게시글', '내용입니다', '관리자');

        
        
 truncate board;	
  
  select * from  board;	

drop table  board;	

insert into  board value();