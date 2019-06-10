create table seat_types (
  id identity not null primary key,
  type varchar(20) not null,
  price decimal(10,2) not null
);

insert into seat_types (type, price) VALUES
  ('Handicap', 11.99),
  ('Standard', 11.99),
  ('Recliner', 12.99),
  ('Loveseat', 13.99);