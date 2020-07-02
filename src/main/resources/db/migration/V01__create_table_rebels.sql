CREATE TABLE rebels(
    id BIGINT auto_increment PRIMARY KEY NOT NULL,
    name VARCHAR(60) NOT NULL,
    gender VARCHAR(15) NOT NULL,
    total_denunciations INTEGER,
    is_renegade BOOLEAN DEFAULT false,
    latitude DOUBLE NOT NULL,
    longitude DOUBLE NOT NULL,
    galaxy_name VARCHAR(80) NOT NULL,
    base_name VARCHAR(80) NOT NULL,
    total_weapons INT NOT NULL,
    total_ammunition INT NOT NULL,
    total_water INT NOT NULL,
    total_food INT NOT NULL
);