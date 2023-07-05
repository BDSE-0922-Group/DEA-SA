package com.MoW.DEASA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.MoW.DEASA.Entity.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long>{

}
