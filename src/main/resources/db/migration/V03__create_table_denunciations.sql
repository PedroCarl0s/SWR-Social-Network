CREATE TABLE denunciations(
    id INTEGER auto_increment PRIMARY KEY NOT NULL,
    total_denunciations INTEGER NOT NULL,
    is_renegade BOOLEAN NOT NULL,
    
    PRIMARY KEY (id),
    CHECK (total_denunciations >= 0)
);