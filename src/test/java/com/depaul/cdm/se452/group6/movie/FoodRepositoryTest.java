package com.depaul.cdm.se452.group6.movie;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.depaul.cdm.se452.group6.movie.entity.Food;
import com.depaul.cdm.se452.group6.movie.finder.FoodRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FoodRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private FoodRepository repository;

	@Test
	public void testFindAll() {
		int numOfRows = repository.findAll().size();
		final int EXPECTED_NUM_OF_ROWS = 8;
		Assert.assertEquals(numOfRows, EXPECTED_NUM_OF_ROWS);
	}

	@Test
	public void testItem() {
	    final String ITEM_NAME = "Popcorn";
	    Food food = repository.findByItem(ITEM_NAME).get(0);
	    String item = food.getItem();
	    Assert.assertEquals(ITEM_NAME, item);
	}

	@Test
	public void testAdd() {
		final String NEW_ITEM = "Snickers";
	    final String NEW_SIZE = "Small";
	    final Double NEW_PRICE = 2.50;

	    Food food = new Food();
	    food.setItem(NEW_ITEM);
	    food.setSize(NEW_SIZE);
	    food.setPrice(NEW_PRICE);

	    entityManager.persist(food);
	    entityManager.flush();

	    Food found = repository.findByItemAndSize(NEW_ITEM, NEW_SIZE).get(0);

	    Assert.assertEquals(found.getItem(), NEW_ITEM);
	    Assert.assertEquals(found.getSize(), NEW_SIZE);
	}

	@Test
	public void testUpdate() {
		final String ORIGINAL_ITEM = "Hotdog";
		final String ORIGINAL_SIZE = "Small";
		//final Double ORIGINAL_PRICE = 2.50;

		final String NEW_ITEM = "Twix";
		final String NEW_SIZE = "Small";
		final Double NEW_PRICE = 2.60;

		Food found = repository.findByItemAndSize(ORIGINAL_ITEM, ORIGINAL_SIZE).get(0);

		found.setItem(NEW_ITEM);
		found.setSize(NEW_SIZE);
		found.setPrice(NEW_PRICE);

		entityManager.persistAndFlush(found);

	    Assert.assertEquals(0, repository.findByItem(ORIGINAL_ITEM).size());
	    Assert.assertEquals(1, repository.findByItem(NEW_ITEM).size());
	}

}
