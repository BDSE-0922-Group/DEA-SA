package com.MoW.DEASA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MoW.DEASA.entity.Meal;
import com.MoW.DEASA.entity.Order;
import com.MoW.DEASA.entity.User;
import com.MoW.DEASA.enums.UserRole;
import com.MoW.DEASA.payload.UpdateUser;
import com.MoW.DEASA.service.MealService;
import com.MoW.DEASA.service.OrderService;
import com.MoW.DEASA.service.UserService;

@RestController
public class AdminController {
	
	// TODO
    // add code that will check the userRole of the user trying to access certain operations
    // deny/grant access and send back console logs when denied
	// unless it'll be handled in the frontend?
	
	private final UserService userService;
	private final MealService mealService;
	private final OrderService orderService;

    @Autowired
    public AdminController(UserService userService, MealService mealService, OrderService orderService) {
        this.userService = userService;
        this.mealService = mealService;
        this.orderService = orderService;
    }
    
    // User Operations (add is in the UserController)
	
	@GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user-{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/user-{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody UpdateUser payload) {
        return userService.updateUser(userId, payload);
    }

    @DeleteMapping("/user-{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("User deleted successfully");
    }
	
	// Meal Operations
    
    @PostMapping("/add-meal")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.createMeal(meal);
    }

    @GetMapping("/meal-{mealId}")
    public Meal getMealById(@PathVariable Long mealId) {
        return mealService.getMealById(mealId);
    }

    @GetMapping("/all-meals")
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @PutMapping("/meal-{mealId}")
    public Meal updateMeal(@PathVariable Long mealId, @RequestBody Meal updatedMeal) {
        return mealService.updateMeal(mealId, updatedMeal);
    }

    @DeleteMapping("/meal-{mealId}")
    public ResponseEntity<String> deleteMeal(@PathVariable Long mealId) {
        mealService.deleteMeal(mealId);
        return ResponseEntity.ok("Meal deleted successfully");
    }
	
	// Order Operations
    
    @GetMapping("/all-partners")
    public List<User> getAllPartners() {
        return userService.getUsersByRole(UserRole.PARTNER);
    }

    @GetMapping("/order-{orderId}")
    public Order getOrder(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/all-orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/order-{orderId}")
    public Order editOrder(@PathVariable Long orderId, @RequestBody Order updatedOrder) {
        return orderService.updateOrder(orderId, updatedOrder);
    }

    @DeleteMapping("/order-{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Order deleted successfully");
    }
	
	// Donation Operations

}
