package com.depaul.cdm.se452.group6.movie.finder;

import org.springframework.data.repository.CrudRepository;
import com.depaul.cdm.se452.group6.movie.entity.Cart;
import java.util.List;

public interface CartRepository extends CrudRepository<Cart, Long> {
	List<Cart> findAll();
	List<Cart> findByUserId(Long userId);
}
