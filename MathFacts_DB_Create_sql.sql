-- create and select the database
DROP DATABASE IF EXISTS math_facts;
CREATE DATABASE math_facts;
USE math_facts;

-- create User table
-- DROP TABLE IF EXISTS User;
Create table math_facts.User (
ID integer primary key auto_increment,
UserName varchar(20) not null,
Password varchar(10) not null,
FirstName varchar(20) not null,
LastName varchar(20) not null,
CONSTRAINT uname unique (UserName)
);

-- create game table
-- DROP TABLE IF EXISTS Game;
Create table math_facts.Game (
ID integer primary key auto_increment,
UserID integer not null,
Type varchar(1) not null unique,
DatePlayed datetime not null,
StartTime decimal(10,2) not null,
EndTime decimal(10,2) not null,
ElapsedTime decimal(10,2) not null,
NumberRight integer not null,
NumberWrong integer not null,
Foreign Key (UserID) references user(ID),
CONSTRAINT u_user_dateplayed unique (UserID, DatePlayed)
);

-- Add some users
insert into user (ID, UserName, Password, FirstName, LastName) VALUES
	(1, 'snblessing', '8675', 'Sean', 'Blessing'),
	(2, 'alblessing', '5894', 'Amy', 'Blessing'),
	(3, 'bnblessing', '1107', 'Bailey', 'Blessing'),
	(4, 'bdblessing', '0917', 'Breck', 'Blessing')
;

-- create a user and grant privileges to that user
GRANT SELECT, INSERT, DELETE, UPDATE
ON math_facts.*
TO math_user@localhost
IDENTIFIED BY 'sesame';