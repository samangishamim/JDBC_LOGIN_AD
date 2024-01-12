CREATE TABLE IF NOT EXISTS users
(
    user_id     SERIAL PRIMARY KEY,
    first_name  VARCHAR(255),
    last_name   VARCHAR(255),
    national_id VARCHAR(255),
    username    VARCHAR(255),
    password    VARCHAR(255)
    );
CREATE TABLE IF NOT EXISTS address
(
    address_id SERIAL PRIMARY KEY,
    country    VARCHAR(50),
    province   VARCHAR(50),
    city       VARCHAR(50),
    street     VARCHAR(50),
    alley      VARCHAR(50),
    number     int,
    user_id int references users(user_id)
    );