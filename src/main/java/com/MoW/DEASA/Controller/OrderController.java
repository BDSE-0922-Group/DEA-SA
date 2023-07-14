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
import com.MoW.DEASA.Repo.MealRepository;
import com.MoW.DEASA.Repo.OrderRepository;
import com.MoW.DEASA.Service.OrderService;
import com.MoW.DEASA.Service.UserService;

@Controller
public class OrderController {

	@Autowired
	UserService userService;

	@Autowired
	OrderService orderService;

	@Autowired
	MealRepository mealRepo;

	@Autowired
	OrderRepository orderRepo;

	@GetMapping("order")
	public String orderPage(@ModelAttribute("order") Orders orders, Model model, Principal principal) {

		String username = principal.getName();

		User user = userService.findLoginUser(username);

		model.addAttribute("userAddress", user.getAddress());

		List<Meal> meals = mealRepo.findAll();
		model.addAttribute("meals", meals);
		return "Member/order";
	}

	@PostMapping("place_order")
	public String placeOrder(@ModelAttribute("order") Orders orders, Model model, Principal principal) {

		String username = principal.getName();

		User user = userService.findLoginUser(username);

		orders.setRecipientId(user.getId());

		orderService.save(orders);
		return "redirect:order-confirmation";
	}

	@PostMapping("order_status")
	public String updateOrder(@RequestParam Long oid, @ModelAttribute("orders") Orders orders) {

		List<Orders> orderInfo = orderService.getSPecificOrders(oid);
		Orders orderRecieved = orderInfo.get(0);

		System.out.println(orderRecieved);

		orderRecieved.setStatus("received");

		orderService.save(orderRecieved);

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

		Long id = user.getId();

		List<Orders> order = orderRepo.findByRecipientId(id);
		model.addAttribute("orders", order);

		return "Member/ongoing-orders";
	}
}
