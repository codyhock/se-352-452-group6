create table drinks (
	id			identity		not null primary key,
  	item 		varchar(50)		not null,
  	size		varchar(50)		not null,
  	price		decimal(10,2)	not null
);

insert into drinks (item, size, price) VALUES ('Soft Drink', 'Small', 3.10);
insert into drinks (item, size, price) VALUES ('Soft Drink', 'Large', 4.20);
insert into drinks (item, size, price) VALUES ('Slushy', 'Small', 4.20);
insert into drinks (item, size, price) VALUES ('Slushy', 'Large', 5.20);
insert into drinks (item, size, price) VALUES ('Dasani', 'Small', 2.20);
insert into drinks (item, size, price) VALUES ('Vitamin Water', 'Small', 2.50);
insert into drinks (item, size, price) VALUES ('Lipton', 'Small', 2.50);
insert into drinks (item, size, price) VALUES ('Honest Tea', 'Small', 2.50);
