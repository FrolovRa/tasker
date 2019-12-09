CREATE TABLE users
(
    id          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255)
);

CREATE TABLE tasks
(
    id               BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY,
    user_id          BIGINT       NOT NULL,
    task_description VARCHAR(255) NOT NULL,
    created          TIMESTAMP    NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);