package com.MoW.DEASA.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	
	// add orderService

	@GetMapping("/view-user/{userId}")
	public String viewUserModal(@PathVariable("userId") Long userId, Model model) {
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "admin/view_user_modal";
	}

	@GetMapping("/edit-user/{userId}")
	public String editUserModal(@PathVariable("userId") Long userId, Model model) {
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "admin/edit_user_modal";
	}

	@PutMapping("/edit-user/{userId}")
	public String editUser(@PathVariable("userId") Long userId, @ModelAttribute("user") User updatedUser) {
		User existingUser = userService.getUserById(userId);
		existingUser.setName(updatedUser.getName());
		userService.update(existingUser);
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/delete-user/{userId}")
	public String deleteUserModal(@PathVariable("userId") Long userId, Model model) {
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);
		return "admin/delete_user_modal";
	}

	@DeleteMapping("/delete-user/{userId}")
	public String deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return "redirect:/admin/dashboard";
	}

	/*
	@GetMapping("/view-order/{orderId}")
	public String viewOrderModal(@PathVariable("orderId") Long orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "admin/view_order_modal";
	}

	@GetMapping("/edit-order/{orderId}")
	public String editOrderModal(@PathVariable("orderId") Long orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "admin/edit_order_modal";
	}

	@PutMapping("/edit-order/{orderId}")
	public String editOrder(@PathVariable("orderId") Long orderId, @ModelAttribute("order") Order updatedOrder) {
		Order existingOrder = orderService.getOrderById(orderId);
		existingOrder.setCustomerName(updatedOrder.getCustomerName());
		orderService.saveOrder(existingOrder);
		return "redirect:/admin/dashboard";
	}

	@GetMapping("/delete-order/{orderId}")
	public String deleteOrderModal(@PathVariable("orderId") Long orderId, Model model) {
		Order order = orderService.getOrderById(orderId);
		model.addAttribute("order", order);
		return "admin/delete_order_modal";
	}

	@DeleteMapping("/delete-order/{orderId}")
	public String deleteOrder(@PathVariable("orderId") Long orderId) {
		orderService.deleteOrderById(orderId);
		return "redirect:/admin/dashboard";
	}
	*/

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		List<User> users = userService.showAllUser();
		// List<Order> orders = orderService.getAllOrders();
		model.addAttribute("users", users);
		// model.addAttribute("orders", orders);
		return "admin/dashboard";
	}
}
