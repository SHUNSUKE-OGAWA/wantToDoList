DROP TABLE IF EXISTS user;

CREATE TABLE user
(
   userId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100) NOT NULL UNIQUE,
   password VARCHAR(100) NOT NULL,
   authority VARCHAR(100)
);

DROP TABLE IF EXISTS todo;
CREATE TABLE todo
(
	todoId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	userId INT NOT NULL,
	significance VARCHAR(500) NOT NULL ,
	method VARCHAR(500) NOT NULL,
	barrier VARCHAR(500) NOT NULL,
	advantage VARCHAR(500) NOT NULL,
	disadvantage VARCHAR(500) NOT NULL
);