DROP TABLE IF EXISTS book;

CREATE TABLE book
(
    isbn varchar(36) NOT NULL,
    title varchar(200) NOT NULL,
    pages int NOT NULL,
    source varchar(36),    
    PRIMARY KEY (isbn)
);
