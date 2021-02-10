DROP TABLE IF EXISTS ACCOUNTDETAILS;

CREATE TABLE ACCOUNTDETAILS (
  ID INTEGER  PRIMARY KEY AUTO_INCREMENT,
  ACCOUNT_NUM VARCHAR(20) NOT NULL,
  UPDATE_DATE TIMESTAMP,
  BALANCE DECIMAL(20, 2) DEFAULT NULL,
  TYPE VARCHAR(10) NOT NULL
);

INSERT INTO ACCOUNTDETAILS (ACCOUNT_NUM, UPDATE_DATE, BALANCE, TYPE) VALUES
  ('abc', '2020-02-09 20:02:03', 24.3, 'Deposit'),
  ('abc', '2019-02-09 20:02:03', 35.3, 'Deposit'),
  ('abc', '2021-02-09 20:20:03', 80.3, 'Deposit'),
  ('abc', '2021-02-09 20:01:03', 30.22, 'Withdraw'),
  ('123', '2021-02-09 20:03:33', 50.12, 'Withdraw'),
  ('123', '2021-02-09 20:03:33', 50.12, 'Withdraw'),
  ('232', '2021-02-09 20:03:33', 50.12, 'Withdraw'),
  ('abc', '2021-02-09 20:03:33', 50.12, 'Withdraw');