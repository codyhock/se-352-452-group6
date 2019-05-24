package com.depaul.cdm.se452.group6.movie;

import com.depaul.cdm.se452.group6.movie.entity.SeatType;
import com.depaul.cdm.se452.group6.movie.finder.SeatTypeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SeatTypeRepositoryTest {

  @Autowired
  private SeatTypeRepository repository;

  @Test
  public void testFindAll() {
    List<SeatType> typeList = repository.findAll();

    final int EXPECTED_NUM_OF_ROWS = 4;
    Assert.assertEquals(typeList.size(), EXPECTED_NUM_OF_ROWS);
  }

  @Test
  public void testFindByType() {
    SeatType standard = repository.findByType("Standard").get();
    SeatType handicap = repository.findByType("Handicap").get();
    SeatType recliner = repository.findByType("Recliner").get();
    SeatType loveseat = repository.findByType("Loveseat").get();

    Assert.assertEquals(standard.getType(), "Standard");
    Assert.assertEquals(handicap.getType(), "Handicap");
    Assert.assertEquals(recliner.getType(), "Recliner");
    Assert.assertEquals(loveseat.getType(), "Loveseat");

  }
}
