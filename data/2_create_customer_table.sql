create table customer
(
id int NOT NULL AUTO_INCREMENT,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
phone varchar(50) NOT NULL,
email varchar(50) NOT NULL,
active boolean NOT NULL,
created_on DATETIME NOT NULL,
updated_on DATETIME,
PRIMARY KEY (id)
);