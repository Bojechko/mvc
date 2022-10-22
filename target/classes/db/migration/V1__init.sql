CREATE TABLE products (id serial, title varchar(100), price int);

CREATE TABLE items (id serial, title varchar(100), price int);

INSERT INTO products (title, price) VALUES ('Bread', 40), ('Milk', 80);

INSERT INTO items (title, price) values ('Box', 50), ('Tree', 10), ('House', 60), ('Bread', 40), ('Milk', 80);;
CREATE TABLE users (
                       username VARCHAR(60) NOT NULL,
                       password VARCHAR(60) NOT NULL,
                       enabled boolean NOT NULL,
                       PRIMARY KEY (username)
);

INSERT INTO users
VALUES
    ('user1', '{noop}123', true),
    ('user2', '{noop}123', true);

CREATE TABLE authorities (
                             username varchar(50) NOT NULL,
                             authority varchar(50) NOT NULL,

                             CONSTRAINT authorities_idx UNIQUE (username, authority),

                             CONSTRAINT authorities_ibfk_1
                                 FOREIGN KEY (username)
                                     REFERENCES users (username)
);

INSERT INTO authorities
VALUES
    ('user1', 'ROLE_ADMIN'),
    ('user1', 'ROLE_USER'),
    ('user2', 'ROLE_USER');