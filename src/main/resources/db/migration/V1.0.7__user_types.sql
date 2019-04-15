create table user_types (
  id identity not null primary key,
  type varchar(20) not null
);

insert into user_types (type) VALUES
  ('Guest'),
  ('Premium'),
  ('Gold'),
  ('VIP');