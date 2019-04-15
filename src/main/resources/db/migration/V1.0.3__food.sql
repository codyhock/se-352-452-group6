create table food (
	id			identity		not null primary key,
  	item 		varchar(50)		not null,
  	size		varchar(50)		not null,
  	price		decimal(10,2)	not null
);

insert into food (item, size, price) VALUES ('Popcorn', 'Regular', 6.50);
insert into food (item, size, price) VALUES ('Popcorn', 'Large', 7.50);
insert into food (item, size, price) VALUES ('Nachos', 'Regular', 4.50);
insert into food (item, size, price) VALUES ('Nachos', 'Large', 5.50);	
insert into food (item, size, price) VALUES ('Hotdog', 'Regular', 4.20);
insert into food (item, size, price) VALUES ('Pretzel', 'Regular', 4.20);
insert into food (item, size, price) VALUES ('French Fries', 'Regular', 4.50);
insert into food (item, size, price) VALUES ('French Fries', 'Large', 5.50);	


