-- Додавання працівників
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES
    ('John Doe', '1990-05-15', 'Senior', 8000),
    ('Jane Smith', '1995-08-22', 'Middle', 5000),
    ('Mark Johnson', '1998-02-10', 'Junior', 3000),
    ('Emily Davis', '2000-11-30', 'Trainee', 1500),
    ('Michael Wilson', '1993-04-05', 'Middle', 5500),
    ('Sarah Taylor', '1988-07-18', 'Senior', 9000),
    ('Robert Anderson', '1992-10-25', 'Junior', 2500),
    ('Olivia Brown', '1997-01-12', 'Trainee', 1200),
    ('William Thomas', '1994-03-20', 'Middle', 4500),
    ('Sophia Miller', '1999-06-08', 'Senior', 7500);

-- Додавання клієнтів
INSERT INTO client (NAME)
VALUES
    ('Emma Robert'),
    ('John Snow'),
    ('Nick Lock'),
    ('Andrew Scott'),
    ('David Kort');

-- Додавання проєктів
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES
    (1, '2022-01-01', '2022-03-31'),
    (2, '2022-02-15', '2022-07-31'),
    (3, '2022-04-10', '2022-05-20'),
    (4, '2022-06-01', '2022-08-31'),
    (5, '2022-03-01', '2022-04-30'),
    (1, '2022-05-15', '2022-12-31'),
    (3, '2022-07-01', '2023-01-31'),
    (2, '2022-08-15', '2023-06-30'),
    (4, '2022-09-10', '2022-11-30'),
    (5, '2022-11-01', '2023-02-28');

-- Додавання працівників на проєкти
INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (2, 4),
    (2, 5),
    (3, 6),
    (3, 7),
    (4, 8),
    (4, 9),
    (5, 10),
    (5, 1),
    (6, 2),
    (6, 3),
    (6, 4),
    (6, 5),
    (7, 6),
    (7, 7),
    (7, 8),
    (8, 9),
    (8, 10),
    (9, 1),
    (9, 2),
    (9, 3),
    (9, 4),
    (9, 5),
    (10, 6),
    (10, 7),
    (10, 8),
    (10, 9),
    (10, 10);