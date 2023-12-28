
CREATE TABLE brand (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE price (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    brand_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    start_dat TIMESTAMP NOT NULL,
    end_dat TIMESTAMP NOT NULL,
    price_list BIGINT NOT NULL,
    priority INT NOT NULL,
    price DOUBLE NOT NULL,
    currency VARCHAR(255) NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brand(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);



