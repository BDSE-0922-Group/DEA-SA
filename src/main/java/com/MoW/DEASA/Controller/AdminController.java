package com.MoW.DEASA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Service.UserService;

@Controller
public class AdminController {

	@Autowired
	UserService userService;
	
	private User findUser(String username) {
		return userService.findUsername(username);
	}
	
	@PostMapping("reassign_user")
	public void reassignUser(@RequestParam("username") String username, @RequestParam("roleString") String role) {
		
		User selectedUser = findUser(username);
		userService.assignNewRole(selectedUser, role);
		return;
	}
	
	@PostMapping("edit_user_info")
	public String editUserInfo(@ModelAttribute("user") User user, @RequestParam String username,
			RedirectAttributes redir) {
		
		User selectedUser = findUser(username);
		
		selectedUser.setName(user.getName());
		selectedUser.setEmail(user.getEmail());
		selectedUser.setMobile(user.getMobile());
		selectedUser.setAddress(user.getAddress());
		
//		userService.update(selectedUser);
		
		String successMsg = "User: " + selectedUser.getName() + "'s information has been updated";
		redir.addFlashAttribute("successMsg", successMsg);
		
		return "redirect:/user-management";
	}
}
