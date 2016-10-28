INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES(1, 'test1', 'test', 'ysh1', 'test1@test.com');
INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL) VALUES(2, 'test2', 'test', 'ysh2', 'test2@test.com');

INSERT INTO QUESTION (id, writer_id, title, contents, create_date) VALUES(1, 1, '국내에서 Ruby on Rails가 ', 'Ruby on Rails(이하 RoR)는', CURRENT_TIMESTAMP());
INSERT INTO QUESTION (id, writer_id, title, contents, create_date) VALUES(2, 2, 'test2가 쓴 글 ', '테스트 2 테스트를 위한 내용', CURRENT_TIMESTAMP());
