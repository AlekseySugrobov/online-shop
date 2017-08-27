drop database onlineshop;

create DATABASE onlineshop;

USE onlineshop;

CREATE TABLE category(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50),
  description VARCHAR(255),
  image_url VARCHAR(50),
  is_active BOOLEAN,
  CONSTRAINT pk_category_id PRIMARY KEY (id)
);

INSERT INTO category (name, description, image_url, is_active) VALUES (
    'Mobile', 'Description for mobile category', 'CAT_3.png', TRUE
);

INSERT INTO category (name, description, image_url, is_active) VALUES (
  'Television', 'Description for Television category', 'CAT_2.png', TRUE
);

INSERT INTO category (name, description, image_url, is_active) VALUES (
  'Laptop', 'Description for laptop category', 'CAT_1.png', TRUE
);

CREATE TABLE user_detail(
  id BIGINT NOT NULL AUTO_INCREMENT,
  fist_name VARCHAR(50),
  last_name VARCHAR(50),
  role VARCHAR(50),
  enabled BOOLEAN,
  password VARCHAR(50),
  email VARCHAR(100),
  contact_number VARCHAR(15),
  CONSTRAINT pk_user_id PRIMARY KEY (id)
);

INSERT INTO user_detail (fist_name, last_name, role, enabled, password, email, contact_number) VALUES (
    'Aleksey', 'Sugrobov', 'ADMIN', TRUE, 'rkg7mnNhfyr', 'admin', '+79923320010'
);

INSERT INTO user_detail (fist_name, last_name, role, enabled, password, email, contact_number) VALUES (
    'Aleksey', 'Sugrobov', 'SUPPLIER', TRUE, 'rkg7mnNhfyr', 'aleksey.sugrobov@gmail.com', '+79923320010'
);

CREATE TABLE product(
  id BIGINT NOT NULL AUTO_INCREMENT,
  code VARCHAR(20),
  name VARCHAR(50),
  brand VARCHAR(50),
  description VARCHAR(255),
  unit_price DECIMAL(10,2),
  quantity int,
  is_active BOOLEAN,
  category_id BIGINT,
  supplier_id BIGINT,
  purchases INT DEFAULT 0,
  views INT DEFAULT 0,
  CONSTRAINT pk_product_id PRIMARY KEY (id),
  FOREIGN KEY (category_id) REFERENCES category(id) on DELETE CASCADE,
  FOREIGN KEY (supplier_id) REFERENCES user_detail(id) on DELETE CASCADE
);

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2 );

INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 2 );