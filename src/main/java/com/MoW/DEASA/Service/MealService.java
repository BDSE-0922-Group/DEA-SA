package com.MoW.DEASA.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MoW.DEASA.Entity.Meal;
import com.MoW.DEASA.Repo.MealRepository;

@Service
@Transactional
public class MealService {
	
	@Autowired
	private MealRepository mealRepo;
	
	public Meal save(Meal meal) {
		return mealRepo.save(meal);
	}
	
	public List<Meal> getAllMeals() {
		return mealRepo.findAll();
	}
	
public void removeMeal(long mid) {
		
		mealRepo.deleteById(mid);
	}

	public Optional<Meal> getMealInfo(long mid) {
		
		return mealRepo.findById(mid);
	}

	public void update(Meal meal) {
		
		mealRepo.save(meal);
	}
}
