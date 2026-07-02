-- =========================
-- 2. Book Table
-- =========================
CREATE TABLE books (
    isbn VARCHAR(13) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    introduction TEXT
);