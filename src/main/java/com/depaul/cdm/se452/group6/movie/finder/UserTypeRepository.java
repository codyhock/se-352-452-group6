package com.depaul.cdm.se452.group6.movie.finder;

import com.depaul.cdm.se452.group6.movie.entity.UserType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {

    List<UserType> findByType(String type);

}
