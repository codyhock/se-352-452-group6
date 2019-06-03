create table theaters (
  id identity not null primary key,
  theater int not null,
  movieID int not null,
  theaterType int not null,
  date date not null,
  time time not null,

  CONSTRAINT UK_THEATERS unique (theater, date, time),
  CONSTRAINT FK_MOVIE foreign key (movieID) references movies(id),
  CONSTRAINT FK_THEATERTYPE foreign key (theaterType) references theater_types(id)
);

insert into theaters (theater, movieID, theaterType, date, time) values
  (1, 4, 1, '2019-04-13', '12:00:00'),
  (2, 1, 2, '2019-04-13', '12:00:00'),
  (3, 3, 3, '2019-04-13', '12:00:00'),
  (3, 1, 3, '2019-04-13', '15:00:00'),
  (1, 1, 1, '2019-04-13', '15:00:00');