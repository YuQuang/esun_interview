-- =========================
-- 3. Inventory Table
-- =========================
CREATE TABLE inventory (
    inventory_id BIGSERIAL PRIMARY KEY,
    isbn VARCHAR(13) NOT NULL,
    store_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(30) NOT NULL,
    CONSTRAINT fk_inventory_book
        FOREIGN KEY (isbn)
        REFERENCES books(isbn)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);