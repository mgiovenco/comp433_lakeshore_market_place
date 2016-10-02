create table customer_order_detail
(
id int NOT NULL AUTO_INCREMENT,
customer_order_id int NOT NULL,
product_id int NOT NULL,
created_on DATETIME NOT NULL,
updated_on DATETIME,
PRIMARY KEY (id),
FOREIGN KEY (customer_order_id)
REFERENCES customer_order(id),
FOREIGN KEY (product_id)
REFERENCES product(id)
);