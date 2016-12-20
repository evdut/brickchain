﻿CREATE TABLE IBRAIN_USER (ID SERIAL NOT NULL, EMAIL VARCHAR(255) UNIQUE NOT NULL, PASSWORD VARCHAR(255), FULLNAME VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE IBRAIN_GROUP (ID  SERIAL NOT NULL, DESCRIPTION VARCHAR(255), GROUP_NAME VARCHAR(255) UNIQUE, PRIMARY KEY (ID));
CREATE TABLE IBRAIN_BOOTSTRAP_VERSION (ID  SERIAL NOT NULL, VERSION INTEGER, PRIMARY KEY (ID));
CREATE TABLE IBRAIN_USER_GROUP (USER_ID BIGINT NOT NULL, GROUP_ID BIGINT NOT NULL, PRIMARY KEY (USER_ID, GROUP_ID));
CREATE TABLE IBRAIN_USER_PHONE (ID SERIAL NOT NULL, USER_ID BIGINT NOT NULL, PHONE_NUMBER VARCHAR(25), PRIMARY KEY (ID));
ALTER TABLE IBRAIN_USER_GROUP ADD CONSTRAINT FK_IBRAIN_USER_GROUP_USER_NAME FOREIGN KEY (USER_ID) REFERENCES IBRAIN_USER (ID);
ALTER TABLE IBRAIN_USER_GROUP ADD CONSTRAINT FK_IBRAIN_USER_GROUP_GROUP_ID FOREIGN KEY (GROUP_ID) REFERENCES IBRAIN_GROUP (ID);
ALTER TABLE IBRAIN_USER_PHONE ADD CONSTRAINT FK_IBRAIN_IBRAIN_USER_PHONE FOREIGN KEY (USER_ID) REFERENCES IBRAIN_USER (ID);
