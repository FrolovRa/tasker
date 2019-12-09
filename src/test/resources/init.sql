INSERT INTO users
VALUES (1, 'test user'),
       (2, 'test user two');
INSERT INTO tasks
VALUES (1, 1, 'task one', parsedatetime('09-12-2019 18:47:52', 'dd-MM-yyyy hh:mm:ss')),
       (2, 1, 'task two', parsedatetime('09-12-2019 18:47:52', 'dd-MM-yyyy hh:mm:ss'));