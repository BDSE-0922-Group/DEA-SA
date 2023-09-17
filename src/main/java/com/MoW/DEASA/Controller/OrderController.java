package com.MoW.DEASA.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MoW.DEASA.Entity.Meal;
import com.MoW.DEASA.Entity.Orders;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.MealService;
import com.MoW.DEASA.Service.OrderService;
import com.MoW.DEASA.Service.UserService;

@Controller
public class OrderController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	MealService mealService;

	@GetMapping("order")
	public String orderPage(@ModelAttribute("order") Orders orders, Model model, Principal principal) {

		String username = principal.getName();

		User user = userService.findLoginUser(username);

		model.addAttribute("userAddress", user.getAddress());

		List<Meal> meals = mealService.getAllMeals();
		model.addAttribute("meals", meals);
		return "Member/order";
	}

	@PostMapping("place_order")
	public String placeOrder(@ModelAttribute("order") Orders orders, @RequestParam("mId") Long mId, 
			Model model, Principal principal) {

		String username = principal.getName();

		User user = userService.findLoginUser(username);
		Meal meal = mealService.findMealById(mId);

		orders.setUser(user);
		orders.setMeal(meal);

		orderService.save(orders);
		return "redirect:order-confirmation";
	}

	@PostMapping("order_status")
	public String updateOrder(@RequestParam Long oid, @ModelAttribute("orders") Orders orders) {

		Orders order = orderService.getOrderById(oid);


		order.setStatus("received");

		orderService.save(order);

		return "redirect:ongoing-orders";

	}

	@GetMapping("order-confirmation")
	public String orderConfirmation() {
		return "Member/confirmation";
	}

	@GetMapping("ongoing-orders")
	public String ongoingOrders(Model model, Principal principal) {

		String username = principal.getName();

		User user = userService.findLoginUser(username);

		List<Orders> order = orderService.getUserOrders(user);
		model.addAttribute("orders", order);

		return "Member/ongoing-orders";
	}
	
	@GetMapping("/orders")
	public String orderManagement(Model model) {
		
		List<Orders> allOrders = orderService.getAllOrders();
		model.addAttribute("orders", allOrders);
		
		return "Partner/orders";
	}
	
	@GetMapping("order_prepared")
	public String orderStatusPrepared(@RequestParam Long oid) {
		
		Orders order = orderService.getOrderById(oid);
		
		order.setStatus("prepared");
		orderService.save(order);
		
		return "redirect:/orders";
	}
}
