create table theater_types (
  id identity not null primary key,
  type varchar(20) not null
);

insert into theater_types (type) VALUES
  ('Standard'),
  ('IMAX'),
  ('3D');