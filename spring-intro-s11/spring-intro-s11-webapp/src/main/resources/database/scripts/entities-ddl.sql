BEGIN TRANSACTION;

DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS ROLE;
DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS
(
  ID            INTEGER GENERATED ALWAYS AS IDENTITY NOT NULL,
  USERNAME      VARCHAR(32) NOT NULL UNIQUE,
  FIRSTNAME     VARCHAR(32) NOT NULL,
  LASTNAME      VARCHAR(32) NOT NULL,
  PASSWORD      VARCHAR(60) NOT NULL,
  ISACTIVE      BOOLEAN NOT NULL DEFAULT TRUE,

  PRIMARY KEY (ID)
);

CREATE TABLE PRODUCT
(
  ID            SMALLINT NOT NULL,
  USERID        INT NOT NULL,
  NAME          VARCHAR(30) NOT NULL UNIQUE,

  PRIMARY KEY (ID),

  FOREIGN KEY (USERID) REFERENCES USERS(ID)
);

CREATE TABLE ROLE
(
  ID            SMALLINT NOT NULL,
  USERID        INT NOT NULL,
  AUTHORITY     VARCHAR(15) NOT NULL UNIQUE,

  PRIMARY KEY (ID),

  FOREIGN KEY (USERID) REFERENCES USERS(ID)
);

------------------------------------------------------------------------------------------------------------------------

INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ISACTIVE)
VALUES (1, 'ana',        'Anamaria', 'Damian', '$2a$10$K5Me7bubxNMs0VAhBcsOAe6ik117kHCRpKz5NUrmsxk.I0f4vyBLS', TRUE); -- spring
INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ISACTIVE)
VALUES (2, 'anita',      'Anita',    'Bejan',  '$2a$10$ji2CjM1tDiJZ9Ggez1HH7uYlWL3sQtGIx7ySlQNuBXnj5cxL1C776', TRUE); -- intro
INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME, PASSWORD, ISACTIVE)
VALUES (3, 'radu',       'Radu',     'Cotiga', '$2a$10$FEcoeljLlk.EROcDwddpiOHh8oM.BgaWCm7npddgdjNItMX4L3oeC', TRUE); -- test

INSERT INTO ROLE (ID, USERID, AUTHORITY) VALUES (1, 1, 'ROLE_ADMIN');
INSERT INTO ROLE (ID, USERID, AUTHORITY) VALUES (2, 2, 'ROLE_MANAGER');
INSERT INTO ROLE (ID, USERID, AUTHORITY) VALUES (3, 3, 'ROLE_USER');

INSERT INTO PRODUCT (ID, USERID, NAME) VALUES (1, 1, 'Samsung Galaxy S5');
INSERT INTO PRODUCT (ID, USERID, NAME) VALUES (2, 2, 'Apple iPhone 6');
INSERT INTO PRODUCT (ID, USERID, NAME) VALUES (3, 3, 'Sony XPeria Z3');

COMMIT;
