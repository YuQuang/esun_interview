-- =========================
-- UP MIGRATION
-- =========================

-- =========================
-- 1. User Table
-- =========================
CREATE TABLE users (
    user_id BIGSERIAL PRIMARY KEY,
    phone_number VARCHAR(20) NOT NULL UNIQUE,
    password TEXT NOT NULL,
    user_name VARCHAR(100) NOT NULL,
    registration_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_login_time TIMESTAMP
);
