create table movies (
  id identity not null primary key,
  name varchar(40) not null,
  runtime int not null,
  rating varchar(10) not null,
  genre varchar(20) not null,
  year int not null,
  image varchar(100),
  CONSTRAINT UK_MOVIES unique (name, year)
);

insert into movies (name, runtime, rating, genre, year, image) values
  ('Avengers: End Game', 182, 'PG-13', 'Action', 2019, 'avengers_endgame_poster.jpg'),
  ('Crypto', 105, 'R', 'Drama', 2019, 'crypto_poster.jpg'),
  ('HellBoy', 121, 'R', 'Action', 2019, 'hellboy_poster.jpg'),
  ('Shahzam!', 132, 'PG-13', 'Action', 2019, 'shazam_poster.jpg');