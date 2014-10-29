DROP TABLE IF EXISTS USER;

CREATE TABLE USER
(
  USERID        INT NOT NULL,
  USERNAME      VARCHAR(32) NOT NULL UNIQUE,
  FIRSTNAME     VARCHAR(32) NOT NULL,
  LASTNAME      VARCHAR(32) NOT NULL,

  PRIMARY KEY (USERID)
);

---------------------------------------------------------------------

INSERT INTO USER (USERID, USERNAME, FIRSTNAME, LASTNAME) VALUES (1, 'ana',        'Anamaria', 'Damian');
INSERT INTO USER (USERID, USERNAME, FIRSTNAME, LASTNAME) VALUES (2, 'anita',      'Anita',    'Bejan');
INSERT INTO USER (USERID, USERNAME, FIRSTNAME, LASTNAME) VALUES (3, 'radu-mamii', 'Radu',     'Cotiga');

COMMIT;
