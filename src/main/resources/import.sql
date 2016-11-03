INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES(1, 'test1', 'test', 'ysh1', 'test1@test.com', CURRENT_TIMESTAMP());
INSERT INTO USER (ID, USER_ID, PASSWORD, NAME, EMAIL, CREATE_DATE) VALUES(2, 'test2', 'test', 'ysh2', 'test2@test.com', CURRENT_TIMESTAMP());

INSERT INTO QUESTION (id, writer_id, title, contents, create_date, count_of_answer) VALUES(1, 1, '국내에서 Ruby on Rails가 ', 'Ruby on Rails(이하 RoR)는', CURRENT_TIMESTAMP(), 0);
INSERT INTO QUESTION (id, writer_id, title, contents, create_date, count_of_answer) VALUES(2, 2, 'test2가 쓴 글 ', '테스트 2 테스트를 위한 내용', CURRENT_TIMESTAMP(), 0);
