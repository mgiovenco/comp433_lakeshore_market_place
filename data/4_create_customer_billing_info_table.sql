create table customer_billing_info
(
id int NOT NULL AUTO_INCREMENT,
credit_card_number varchar(20) NOT NULL,
credit_card_expiration varchar(4) NOT NULL,
active boolean NOT NULL,
created_on DATETIME NOT NULL,
updated_on DATETIME,
customer_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (customer_id)
REFERENCES customer(id)
);