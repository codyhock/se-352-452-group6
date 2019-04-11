create table seat_types (
  id identity not null primary key,
  type varchar(20) not null
);

insert into seat_types (type) VALUES
  ('Handicap'),
  ('Standard'),
  ('Recliner'),
  ('Loveseat');