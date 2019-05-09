create table movies (
  id identity not null primary key,
  name varchar(40) not null,
  runtime int not null,
  rating varchar(10) not null,
  genre varchar(20) not null,
  year int not null,

  CONSTRAINT UK_MOVIES unique (name, year)
);

insert into movies (name, runtime, rating, genre, year) values
  ('Avengers: End Game', 182, 'PG-13', 'Action', 2019),
  ('Crypto', 105, 'R', 'Drama', 2019),
  ('HellBoy', 121, 'R', 'Action', 2019),
  ('Shahzam!', 132, 'PG-13', 'Action', 2019);