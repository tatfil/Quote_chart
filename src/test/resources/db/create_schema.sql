--CREATE SCHEMA IF NOT EXISTS quote_chart;



drop table quote if exists;
drop table vote if exists;
drop table user_table if exists;


CREATE TABLE IF NOT EXISTS user_table
(
    user_id                  UUID PRIMARY KEY,
    name                     VARCHAR(30)         NOT NULL,
    signup_date              DATE                NOT NULL,
    password                 VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS quote
(
    quote_id                 UUID PRIMARY KEY,
    text                     VARCHAR(255) NOT NULL,
    date                     DATE,
    user_id                  UUID,
    rating                   VARCHAR(30) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_table (user_id)
);

CREATE TABLE IF NOT EXISTS vote
(
    vote_id                  UUID PRIMARY KEY,
    date                     DATE,
    quote_id                 UUID,
    user_id                  UUID,
    FOREIGN KEY (quote_id) REFERENCES quote(quote_id),
    FOREIGN KEY(user_id) REFERENCES user_table(user_id)
);