CREATE DATABASE IF NOT EXISTS Todo;

USE Todo;

CREATE TABLE IF NOT EXISTS Task(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    status BOOLEAN NOT NULL
);

INSERT INTO Task(name, status)
VALUES	('Wash the dishes', false);

SELECT Task.*
FROM Task;

UPDATE Task
SET status = true
WHERE id = 1;

SELECT Task.*
FROM Task;
