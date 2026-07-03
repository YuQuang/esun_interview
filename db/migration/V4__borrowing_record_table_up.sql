-- =========================
-- 4. Borrowing Record Table
-- =========================
CREATE TABLE borrowing_record (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    inventory_id BIGINT NOT NULL,
    borrowing_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    return_time TIMESTAMP,
    CONSTRAINT fk_borrow_user
        FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_borrow_inventory
        FOREIGN KEY (inventory_id)
        REFERENCES inventory(inventory_id)
        ON DELETE CASCADE
);

-- =========================
-- Indexes (提升查詢效能)
-- =========================
CREATE INDEX idx_borrow_user_id ON borrowing_record(user_id);
CREATE INDEX idx_borrow_inventory_id ON borrowing_record(inventory_id);
CREATE INDEX idx_inventory_isbn ON inventory(isbn);