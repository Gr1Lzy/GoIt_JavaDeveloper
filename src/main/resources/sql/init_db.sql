-- Команда для створення таблиці worker
CREATE TABLE worker
(
    ID       INT PRIMARY KEY AUTO_INCREMENT,
    NAME     VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000),
    BIRTHDAY DATE CHECK (YEAR(BIRTHDAY) > 1900),
    LEVEL    VARCHAR(10)   NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
    SALARY   INT CHECK (SALARY BETWEEN 100 AND 100000)
);

-- Команда для створення таблиці client
CREATE TABLE client
(
    ID   INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000)
);

-- Команда для створення таблиці project
CREATE TABLE project
(
    ID          INT PRIMARY KEY AUTO_INCREMENT,
    CLIENT_ID   INT,
    START_DATE  DATE,
    FINISH_DATE DATE,
    FOREIGN KEY (CLIENT_ID) REFERENCES client (ID)
);

-- Команда для створення таблиці project_worker
CREATE TABLE project_worker
(
    PROJECT_ID INT,
    WORKER_ID  INT,
    PRIMARY KEY (PROJECT_ID, WORKER_ID),
    FOREIGN KEY (PROJECT_ID) REFERENCES project (ID),
    FOREIGN KEY (WORKER_ID) REFERENCES worker (ID)
);

