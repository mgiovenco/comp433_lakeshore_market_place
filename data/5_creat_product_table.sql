CREATE TABLE product
(
  id VARCHAR (255) NOT NULL,
  vendor_product_id  VARCHAR (255) NOT NULL,
  name  VARCHAR (255)  NOT NULL,
  description  VARCHAR (255) NOT NULL,
  product_available VARCHAR (255) NOT NULL,
  category_id  VARCHAR (255) NOT NULL,
  partner_id  VARCHAR (255)  NOT NULL,
  picture VARCHAR (255) NOT NULL,
  PRIMARY KEY (id)
  );