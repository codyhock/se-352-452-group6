create table food (
	id			identity		not null primary key,
  	item 		varchar(50)		not null,
  	size		varchar(50)		not null,
  	price		decimal(10,2)	not null
);

insert into food (item, size, price) VALUES ('Popcorn', 'Small', 6.50);
insert into food (item, size, price) VALUES ('Popcorn', 'Large', 7.50);
insert into food (item, size, price) VALUES ('Nachos', 'Small', 4.50);
insert into food (item, size, price) VALUES ('Nachos', 'Large', 5.50);
insert into food (item, size, price) VALUES ('Hotdog', 'Small', 4.20);
insert into food (item, size, price) VALUES ('Pretzel', 'Small', 4.20);
insert into food (item, size, price) VALUES ('French Fries', 'Small', 4.50);
insert into food (item, size, price) VALUES ('French Fries', 'Large', 5.50);
