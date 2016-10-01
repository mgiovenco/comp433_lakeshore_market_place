create table payment
(
id int NOT NULL AUTO_INCREMENT,
customer_order_id int NOT NULL,
type varchar(10) NOT NULL,
status varchar(10) NOT NULL,
created_on DATETIME NOT NULL,
updated_on DATETIME,
PRIMARY KEY (id),
FOREIGN KEY (customer_order_id)
REFERENCES customer_order(id)
);