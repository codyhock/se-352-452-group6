create table alcohol (
  id identity not null primary key,
  type varchar(20) not null,
  price decimal(5,2) not null,
);

insert into alcohol (type,price) VALUES
  ('Beer',8.00),
  ('Wine',14.00),
  ('Tequila',20.00),
  ('Rum',18.00),
  ('Vodka',18.00),
  ('Gin',20.00),
  ('Whiskey',16.00);