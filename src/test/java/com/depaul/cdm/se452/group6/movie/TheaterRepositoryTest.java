package com.depaul.cdm.se452.group6.movie;

import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.entity.TheaterType;
import com.depaul.cdm.se452.group6.movie.finder.MovieRepository;
import com.depaul.cdm.se452.group6.movie.finder.TheaterRepository;
import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.finder.TheaterTypeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TheaterRepositoryTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private TheaterRepository repository;

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private TheaterTypeRepository theaterTypeRepository;

  @Test
  public void testFindAll() {
    int numOfRows = repository.findAll().size();
    final int EXPECTED_NUM_OF_ROWS = 5;
    Assert.assertEquals(numOfRows, EXPECTED_NUM_OF_ROWS);
  }

  @Test
  public void testTheater() {
    final int THEATER_NUM = 2;
    //final LocalDateTime TIME_STAMP = LocalDateTime.of(2019,4,13,12,0);
    final LocalDate DATE = LocalDate.of(2019,4,13);
    final LocalTime TIME = LocalTime.of(12, 0);
    final String MOVIE_NAME = "Avengers: End Game";
    final int RUN_TIME = 182;

    Theater theater = repository.findByTheaterAndDateAndTime(THEATER_NUM, DATE, TIME).get(0);
    int theaterNumber = theater.getTheater();
    Movie movie = theater.getMovieID();
    String movieName = movie.getName();
    int runtime = movie.getRuntime();
    LocalDate date = theater.getDate();
    LocalTime time = theater.getTime();

    Assert.assertEquals(movieName, MOVIE_NAME);
    Assert.assertEquals(theaterNumber, THEATER_NUM);
    Assert.assertEquals(date, DATE);
    Assert.assertEquals(time, TIME);
    Assert.assertEquals(runtime, RUN_TIME);
  }

  @Test
  public void testAdd() {
    final String MOVIE_NAME = "Avengers: End Game";
    final int THEATER_NUM = 1;
    final Movie MOVIE = movieRepository.findByName(MOVIE_NAME).get(0);
    final TheaterType THEATER_TYPE = theaterTypeRepository.findByType("Standard").get(0);
    final LocalDate DATE = LocalDate.of(2019,4,13);
    final LocalTime TIME = LocalTime.of(18,0);

    Theater test = new Theater();
    test.setTheater(THEATER_NUM);
    test.setDate(DATE);
    test.setTime(TIME);
    test.setMovieID(MOVIE);
    test.setTheaterType(THEATER_TYPE);

    entityManager.persist(test);
    entityManager.flush();

    Theater found = repository.findByTheaterAndDateAndTime(THEATER_NUM, DATE, TIME).get(0);

    Assert.assertEquals(found.getDate(), DATE);
    Assert.assertEquals(found.getTime(), TIME);
    Movie foundMovie = found.getMovieID();
    Assert.assertEquals(foundMovie.getId(), MOVIE.getId());
  }

  @Test
  public void testUpdate() {
    final int THEATER_NUM = 1;
    final LocalDate DATE = LocalDate.of(2019,4,13);
    final LocalTime TIME = LocalTime.of(15,0);
    final LocalDate NEW_DATE = LocalDate.of(2019,4,13);
    final LocalTime NEW_TIME = LocalTime.of(18,0);
    Theater found = repository.findByTheaterAndDateAndTime(THEATER_NUM, DATE, TIME).get(0);
    found.setDate(NEW_DATE);
    found.setTime(NEW_TIME);
    entityManager.persistAndFlush(found);

    Assert.assertEquals(0, repository.findByTheaterAndDateAndTime(THEATER_NUM, DATE, TIME).size());
    Assert.assertEquals(1, repository.findByTheaterAndDateAndTime(THEATER_NUM, NEW_DATE, NEW_TIME).size());
  }
}
