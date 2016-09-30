create table customer_address
(
id int NOT NULL AUTO_INCREMENT,
address_line_1 varchar(50) NOT NULL,
address_line_2 varchar(50) NOT NULL,
city varchar(50) NOT NULL,
state varchar(50) NOT NULL,
postal_code varchar(10) NOT NULL,
country varchar(50) NOT NULL,
billing_address boolean NOT NULL,
shipping_address boolean NOT NULL,
active boolean NOT NULL,
created_on DATETIME NOT NULL,
updated_on DATETIME,
customer_id int NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (customer_id)
REFERENCES customer(id)
);