\c dbelastic

CREATE SCHEMA app AUTHORIZATION "eldg_app";

CREATE TABLE IF NOT EXISTS app.product (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    active BOOLEAN NOT NULL,
    start_date DATE
);

CREATE TABLE IF NOT EXISTS app.sky (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    color VARCHAR(50),
    available BOOLEAN NOT NULL,
    product_id BIGINT,
    CONSTRAINT fk_product
      FOREIGN KEY(product_id)
      REFERENCES app.product(id)
);
