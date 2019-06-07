package com.depaul.cdm.se452.group6.movie;

import com.depaul.cdm.se452.group6.movie.entity.Seat;
import com.depaul.cdm.se452.group6.movie.entity.SeatType;
import com.depaul.cdm.se452.group6.movie.entity.Theater;
import com.depaul.cdm.se452.group6.movie.finder.SeatRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SeatRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private SeatRepository repository;

  @Test
  public void testFindAll() {
    int numOfRows = repository.findAll().size();
    final int EXPECTED_NUM_OF_ROWS = 240;
    Assert.assertEquals(EXPECTED_NUM_OF_ROWS, numOfRows);
  }

  @Test
  public void testFindByTheater() {
    Long theater = 1L;
    int numOfRows = repository.findByTheaterId(theater).size();
    final int EXPECTED_NUM_OF_ROWS = 40;
    Assert.assertEquals(numOfRows, EXPECTED_NUM_OF_ROWS);
  }

  @Test
  public void testFindById() {
    Long seatId = 1L;
    Seat seat = repository.findById(seatId).get();

    long seatNum = seat.getSeatNumber();
    String avail = seat.getAvailability();
    SeatType type = seat.getSeatType();
    Theater theater = seat.getTheater();

    Assert.assertEquals(1, seatNum);
    Assert.assertEquals("Available", avail);
    Assert.assertEquals("Handicap", type.getType());
    Assert.assertEquals(1, theater.getTheater());
  }

  @Test
  public void testUpdate() {
    Long seatId = 1L;
    Seat found = repository.findById(seatId).get();

    Assert.assertEquals("Available", found.getAvailability());

    found.setAvailability("Unavailable");
    entityManager.persist(found);
    entityManager.flush();

    Seat updated = repository.findById(seatId).get();

    Assert.assertEquals("Unavailable", updated.getAvailability());
  }


}
