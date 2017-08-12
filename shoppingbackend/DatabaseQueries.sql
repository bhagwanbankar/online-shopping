CREATE TABLE category(
	id IDENTITY,
	name varchar(50),
	description varchar(255),
	image_url varchar(50),
	is_active boolean,
	CONSTRAINT pk_category_id PRIMARY KEY (id)

);

INSERT INTO category(name,description,image_url,is_active) VALUES('Desktop','This is a description for category Desktop','CAT_4.png',true);