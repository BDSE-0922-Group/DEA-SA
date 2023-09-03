package com.MoW.DEASA.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MoW.DEASA.Entity.Meal;
import com.MoW.DEASA.Service.MealService;

@Controller
public class MealController {

	@Autowired
	MealService mealService;
	
	@GetMapping("post-meal")
	public String postMealForm(@ModelAttribute("meal") Meal meal) { 
		
		return "Partner/meal";
	}
	
	@PostMapping("post_meal")
	public String postMeal(Model model, @ModelAttribute("meal") Meal meal, RedirectAttributes ra,
			@RequestParam("fileImage") MultipartFile multipartFile, Principal principal) throws IOException {
		
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		meal.setPhotos(fileName);
		Meal savedMeal = mealService.save(meal);
		
		String uploadDir = "./src/main/resources/static/images/meal-photo/" + savedMeal.getId();
		Path uploadPath = Paths.get(uploadDir);
		
		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		try (InputStream inputStream = multipartFile.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			System.out.println(filePath.toFile().getAbsolutePath());
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			throw new IOException("Could not save uploaded file: " + fileName);
		}
		
		meal.setPhotoImagePath("/images/meal-photo/" + savedMeal.getId() + "/" + savedMeal.getPhotos());

		mealService.save(meal);
		
		return "Partner/dashboard";
	}
	
	@PostMapping("edit_meal")
	public String editMeal(@RequestParam long id, @ModelAttribute("meal") Meal meal) {
		
		Meal currentMeal = mealService.findMealById(id);
		
		System.out.println("connected" + id);
		System.out.println(meal.getAvailability());
		System.out.println(meal.getName());
		System.out.println(meal.getDescription());
		
		return "redirect:dashboard";
	}
}
