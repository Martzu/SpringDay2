

CREATE TABLE IF NOT EXISTS normal_user(
    id serial PRIMARY KEY,
    username VARCHAR(64) NOT NULL,
    password VARCHAR(64) NOT NULL
);

