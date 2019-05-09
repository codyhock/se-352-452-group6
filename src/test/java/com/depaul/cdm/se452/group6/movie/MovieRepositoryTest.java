package com.depaul.cdm.se452.group6.movie;

import com.depaul.cdm.se452.group6.movie.entity.Movie;
import com.depaul.cdm.se452.group6.movie.finder.MovieRepository;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private MovieRepository repository;

  @Test
  public void testFindAll() {
    int numOfRows = repository.findAll().size();
    final int EXPECTED_NUM_OF_ROWS = 4;
    Assert.assertEquals(numOfRows, EXPECTED_NUM_OF_ROWS);
  }

  @Test
  public void testMovie() {
    final String MOVIE_NAME = "Avengers: End Game";
    final int RUN_TIME = 182;
    Movie movie = repository.findByName(MOVIE_NAME).get(0);
    String name = movie.getName();
    int runtime = movie.getRuntime();
    Assert.assertEquals(name, MOVIE_NAME);
    Assert.assertEquals(runtime, RUN_TIME);
  }

  @Test
  public void testAdd() {
    final String MOVIE_NAME = "a test";
    final int RUN_TIME = 182;
    final String  MOVIE_RATING = "PG";
    final String MOVIE_GENRE = "Action";
    final int MOVIE_YEAR = 2015;

    Movie test = new Movie();
    test.setName(MOVIE_NAME);
    test.setRuntime(RUN_TIME);
    test.setRating(MOVIE_RATING);
    test.setGenre(MOVIE_GENRE);
    test.setYear(MOVIE_YEAR);

    entityManager.persist(test);
    entityManager.flush();

    Movie found = repository.findByName(MOVIE_NAME).get(0);

    Assert.assertEquals(found.getName(), MOVIE_NAME);
  }

  @Test
  public void testUpdate() {
    final String ORIGINAL_MOVIE_NAME = "Avengers: End Game";
    final int ORIGINAL_RUN_TIME = 182;
    final String NEW_MOVIE_NAME = "update test";
    final int NEW_RUN_TIME = 190;

    Movie found = repository.findByName(ORIGINAL_MOVIE_NAME).get(0);
    found.setName(NEW_MOVIE_NAME);
    found.setRuntime(NEW_RUN_TIME);
    entityManager.persistAndFlush(found);

    // Should not find any from original flight number and find one in the new flight number
    Assert.assertEquals(0, repository.findByName(ORIGINAL_MOVIE_NAME).size());
    Assert.assertEquals(1, repository.findByName(NEW_MOVIE_NAME).size());
  }
}
