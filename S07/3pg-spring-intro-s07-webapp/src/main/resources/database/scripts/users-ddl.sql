DROP TABLE IF EXISTS USERS;

CREATE TABLE USERS
(
  USERID        INT NOT NULL,
  USERNAME      VARCHAR(32) NOT NULL UNIQUE,
  FIRSTNAME     VARCHAR(32) NOT NULL,
  LASTNAME      VARCHAR(32) NOT NULL,

  PRIMARY KEY (USERID)
);

---------------------------------------------------------------------

INSERT INTO USERS (USERID, USERNAME, FIRSTNAME, LASTNAME) VALUES (1, 'ana',        'Anamaria', 'Damian');
INSERT INTO USERS (USERID, USERNAME, FIRSTNAME, LASTNAME) VALUES (2, 'anita',      'Anita',    'Bejan');
INSERT INTO USERS (USERID, USERNAME, FIRSTNAME, LASTNAME) VALUES (3, 'radu-mamii', 'Radu',     'Cotiga');

COMMIT;
