package com.MoW.DEASA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

}
