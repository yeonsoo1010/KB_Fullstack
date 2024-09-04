use jdbc_ex;

CREATE TABLE TODO (
                      ID          INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
                      TITLE       VARCHAR(128) NOT NULL,
                      DESCRIPTION VARCHAR(512) NULL,
                      DONE        BOOLEAN,
                      USERID     VARCHAR(12) NOT NULL,
                      FOREIGN KEY (USERID) REFERENCES USERS(ID)
                          ON UPDATE CASCADE
                          ON DELETE CASCADE
);
INSERT INTO todo(title, description, done, userid)
values ('야구장', '프로야구경기도봐야합니다.', false, 'guest'),
       ('놀기', '노는것도중요합니다.', false, 'guest'),
       ('Vue학습', 'Vue학습을해야합니다', false, 'member'),
       ('ES6 공부', 'ES6공부를해야합니다', true, 'guest');