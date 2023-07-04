package com.MoW.DEASA.service;

import com.MoW.DEASA.entity.Meal;
import com.MoW.DEASA.repo.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private final MealRepository mealRepository;

    public MealService(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    public Meal createMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal getMealById(Long mealId) {
        return mealRepository.findById(mealId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid meal ID"));
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public Meal updateMeal(Long mealId, Meal updatedMeal) {
        Meal meal = getMealById(mealId);
        meal.setMealName(updatedMeal.getMealName());
        meal.setMealDescription(updatedMeal.getMealDescription());
        meal.setMealStatus(updatedMeal.getMealStatus());
        return mealRepository.save(meal);
    }

    public void deleteMeal(Long mealId) {
        mealRepository.deleteById(mealId);
    }
}
