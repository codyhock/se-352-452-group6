create table theaters (
  theaterID int not null,
  name varchar(40) not null,
  movieName varchar(40) not null,
  movieYear int not null,
  theaterType int not null,
  screen int not null,
  time timestamp not null,

  CONSTRAINT PK_THEATERS primary key (theaterID, screen, time),
  CONSTRAINT FK_MOVIE foreign key (movieName, movieYear) references movies(name, year),
  CONSTRAINT FK_THEATERTYPE foreign key (theaterType) references theater_types(id)
);

insert into theaters values
  (1, 'AMC Woodfield', 'Avengers: End Game', 2019, 2, 1, '2019-04-13 12:00:00'),
  (1, 'AMC Woodfield', 'Shahzam!', 2019, 1, 1, '2019-04-13 15:00:00'),
  (1, 'AMC Woodfield', 'Avengers: End Game', 2019, 2, 2, '2019-04-13 12:00:00'),
  (1, 'AMC Woodfield', 'Avengers: End Game', 2019, 3, 3, '2019-04-13 12:00:00'),
  (2, 'AMC River East', 'Shahzam!', 2019, 3, 1, '2019-04-13 12:00:00'),
  (2, 'AMC River East', 'Shahzam!', 2019, 1, 2, '2019-04-13 12:00:00'),
  (2, 'AMC River East', 'HellBoy', 2019, 2, 2, '2019-04-13 15:00:00');