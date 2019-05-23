package com.depaul.cdm.se452.group6.movie;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.depaul.cdm.se452.group6.movie.entity.Drink;
import com.depaul.cdm.se452.group6.movie.finder.DrinkRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DrinkRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private DrinkRepository repository;

	@Test
	public void testFindAll() {
		int numOfRows = repository.findAll().size();
		final int EXPECTED_NUM_OF_ROWS = 8;
		Assert.assertEquals(numOfRows, EXPECTED_NUM_OF_ROWS);
	}

	@Test
	public void testItem() {
	    final String ITEM_NAME = "Soft Drink";
	    Drink drink = repository.findByItem(ITEM_NAME).get(0);
	    String item = drink.getItem();
	    Assert.assertEquals(ITEM_NAME, item);
	}

	@Test
	public void testAdd() {
		final String NEW_ITEM = "Gatorade";
	    final String NEW_SIZE = "Large";
	    final Double NEW_PRICE = 2.50;

	    Drink drink = new Drink();
	    drink.setItem(NEW_ITEM);
	    drink.setSize(NEW_SIZE);
	    drink.setPrice(NEW_PRICE);

	    entityManager.persist(drink);
	    entityManager.flush();

	    Drink found = repository.findByItemAndSize(NEW_ITEM, NEW_SIZE).get(0);

	    Assert.assertEquals(found.getItem(), NEW_ITEM);
	    Assert.assertEquals(found.getSize(), NEW_SIZE);
	}

	@Test
	public void testUpdate() {
		final String ORIGINAL_ITEM = "Soft Drink";
		final String ORIGINAL_SIZE = "Small";

		final String NEW_ITEM = "Soda";
		final String NEW_SIZE = "Small";
		final Double NEW_PRICE = 2.60;

		Drink found = repository.findByItemAndSize(ORIGINAL_ITEM, ORIGINAL_SIZE).get(0);

		found.setItem(NEW_ITEM);
		found.setSize(NEW_SIZE);
		found.setPrice(NEW_PRICE);

		entityManager.persistAndFlush(found);

		// Soft Drink has 2 sizes
	    Assert.assertEquals(1, repository.findByItem(ORIGINAL_ITEM).size());
	    Assert.assertEquals(1, repository.findByItem(NEW_ITEM).size());
	}

}
