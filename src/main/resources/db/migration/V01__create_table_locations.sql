CREATE TABLE locations(
    id INTEGER auto_increment PRIMARY KEY NOT NULL,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    galaxy_name VARCHAR(80) NOT NULL
);