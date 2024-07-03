drop table if exists my_table;

CREATE TABLE IF NOT EXISTS my_table (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO my_table (name) VALUES ('HIKIDA');
INSERT INTO my_table (name) VALUES ('TANAKA');