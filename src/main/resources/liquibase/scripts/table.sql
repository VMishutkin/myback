-- liquibase formatted sql

-- changeset vmish:1

CREATE TABLE users
(
    id           SERIAL PRIMARY KEY,
    username     TEXT UNIQUE,
    password     TEXT,
    enabled      TEXT,
    role         TEXT,
    first_name   TEXT,
    last_name    TEXT,
    phone        TEXT,
    email        TEXT,
    reg_date     TEXT,
    city         TEXT,
    image        TEXT
);


CREATE TABLE ads
(
    pk           SERIAL PRIMARY KEY,
    title        TEXT,
    price        INTEGER,
    image        TEXT,
    author_id       INTEGER REFERENCES users(id)
);


CREATE TABLE comments
(
    pk           SERIAL PRIMARY KEY,
    created_at   TEXT,
    text         TEXT,
    author_id       INTEGER REFERENCES users(id),
    ad_pk       INTEGER REFERENCES ads(pk)
);


CREATE TABLE authorities
(
    id           SERIAL PRIMARY KEY,
    username     TEXT UNIQUE,
    authority    TEXT
);


