BEGIN TRANSACTION;

DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS PRODUCT;

CREATE TABLE USERS
(
  ID            INT NOT NULL,
  USERNAME      VARCHAR(32) NOT NULL UNIQUE,
  FIRSTNAME     VARCHAR(32) NOT NULL,
  LASTNAME      VARCHAR(32) NOT NULL,

  PRIMARY KEY (ID)
);

CREATE TABLE PRODUCT
(
  ID            INT NOT NULL,
  USERID        INT NOT NULL,
  NAME          VARCHAR(30) NOT NULL UNIQUE,

  PRIMARY KEY (ID),

  FOREIGN KEY (USERID) REFERENCES USERS(ID)
);

---------------------------------------------------------------------

INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME) VALUES (1, 'ana',        'Anamaria', 'Damian');
INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME) VALUES (2, 'anita',      'Anita',    'Bejan');
INSERT INTO USERS (ID, USERNAME, FIRSTNAME, LASTNAME) VALUES (3, 'radu-mamii', 'Radu',     'Cotiga');

INSERT INTO PRODUCT (ID, USERID, NAME) VALUES (1, 1, 'Samsung Galaxy S5');
INSERT INTO PRODUCT (ID, USERID, NAME) VALUES (2, 2, 'Apple iPhone 6');
INSERT INTO PRODUCT (ID, USERID, NAME) VALUES (3, 3, 'Sony XPeria Z3');

COMMIT;
