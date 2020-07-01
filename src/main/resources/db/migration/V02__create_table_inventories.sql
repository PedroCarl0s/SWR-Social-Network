CREATE TABLE inventories(
    id INTEGER auto_increment PRIMARY KEY NOT NULL,
    total_weapons INT NOT NULL,
    total_ammunition INT NOT NULL,
    total_water INT NOT NULL,
    total_food INT NOT NULL,

    CHECK (total_weapons >= 0),
    CHECK (total_ammunition >= 0),
    CHECK (total_water >= 0),
    CHECK (total_food >= 0)
);