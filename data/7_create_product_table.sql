CREATE TABLE product
(
  id int NOT NULL AUTO_INCREMENT,
  vendor_product_id  VARCHAR (255) NOT NULL,
  name  VARCHAR (255)  NOT NULL,
  description  VARCHAR (255) NOT NULL,
  product_available VARCHAR (255) NOT NULL,
  picture VARCHAR (255) NOT NULL,
  category_id int NOT NULL,
  partner_id int NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (category_id)
  REFERENCES category(id),
  FOREIGN KEY (partner_id)
  REFERENCES partner(id)
  );
  
 