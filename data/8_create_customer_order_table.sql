create table customer_order
(
id int NOT NULL AUTO_INCREMENT,
order_total DECIMAL(10,2) NOT NULL,
order_status varchar(50) NOT NULL,
tracking_id varchar(5) NOT NULL,
customer_id int NOT NULL,
billing_info_id int NOT NULL,
shipping_info_id int NOT NULL,
created_on DATETIME NOT NULL,
updated_on DATETIME,
PRIMARY KEY (id),
FOREIGN KEY (customer_id)
REFERENCES customer(id),
FOREIGN KEY (billing_info_id)
REFERENCES customer_billing_info(id),
FOREIGN KEY (shipping_info_id)
REFERENCES customer_billing_info(id)
);