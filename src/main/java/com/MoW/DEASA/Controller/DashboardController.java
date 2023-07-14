package com.MoW.DEASA.Controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MoW.DEASA.Entity.Donation;
import com.MoW.DEASA.Entity.Events;
import com.MoW.DEASA.Entity.Meal;
import com.MoW.DEASA.Entity.Role;
import com.MoW.DEASA.Entity.User;
import com.MoW.DEASA.Repo.EventsRepository;
import com.MoW.DEASA.Repo.MealRepository;
import com.MoW.DEASA.Service.DonationService;
import com.MoW.DEASA.Service.UserService;

@Controller
public class DashboardController {

	@Autowired
	UserService userService;

	@Autowired
	DonationService dService;

	@Autowired
	MealRepository mealRepo;

	@Autowired
	EventsRepository eventRepo;

	@GetMapping("dashboard")
	public String dashboard(Principal principal, Model model) {
		String username = principal.getName();

		User user = userService.findLoginUser(username);

		String[] role = user.getRoles().stream().map(Role::getName).toArray(String[]::new);

		String userRole = role[0];

		String[] roleNames = userService.getAllRoles().stream().map(Role::getName).toArray(String[]::new);

		for (String roleName : roleNames) {
			if (roleName == userRole && userRole.equalsIgnoreCase("Administrator")) {
				adminDashboard();
				return userRole + "/dashboard";
			}
			if (roleName == userRole && userRole.equalsIgnoreCase("Member")) {
				memberDashboard(model);
				return userRole + "/dashboard";
			}
			if (roleName == userRole && userRole.equalsIgnoreCase("Caregiver")) {
				caregiverDashboard();
				return userRole + "/dashboard";
			}
			if (roleName == userRole && userRole.equalsIgnoreCase("Partner")) {
				partnerDashboard(model);
				return userRole + "/dashboard";
			}
			if (roleName == userRole && userRole.equalsIgnoreCase("Volunteer")) {
				volunteerDashboard(model);
				return userRole + "/dashboard";
			}
			if (roleName == userRole && userRole.equalsIgnoreCase("Donator")) {
				donatorDashboard(model, principal);
				return userRole + "/dashboard";
			}
		}
		return "redirect:accessdenied";
	}

	public void adminDashboard() {
		System.out.println("Logged in as Administrator");
	}

	public void memberDashboard(Model model) {

		List<Meal> meals = mealRepo.findAll();
		model.addAttribute("meals", meals);
	}

	public void caregiverDashboard() {
		System.out.println("Logged in as Caregiver");
	}

	public void partnerDashboard(Model model) {

		List<Meal> meals = mealRepo.findAll();
		model.addAttribute("meals", meals);
	}

	public void volunteerDashboard(Model model) {

		List<Events> events = eventRepo.findAll();
		model.addAttribute("events", events);
	}

	public void donatorDashboard(Model model, Principal principal) {

		Double[] total_donations = (dService.getAllDonations().stream().map(Donation::getAmount)
				.toArray(Double[]::new));

		double total_donation_amount = sum(total_donations);

		double ave_not_rounded = total_donation_amount / total_donations.length;

		double average_donation_amount = Math.round(ave_not_rounded * 100.0) / 100.0;

		int total_donation = total_donations.length;

		String username = principal.getName();

		User user = userService.findLoginUser(username);

		long uId = user.getId();

		List<Donation> donation = dService.getSpecificDonation(uId);
		List<Donation> recent = donation.subList(Math.max(donation.size() - 5, 0), donation.size());

		model.addAttribute("total_donation_amount", total_donation_amount);
		model.addAttribute("average_donation_amount", average_donation_amount);
		model.addAttribute("total_donation", total_donation);
		model.addAttribute("recent", recent);

		System.out.println("Logged in as Donator");
	}

	public static Double sum(final Double[] doubles) {
		Double sum = 0.0;
		for (int j = 0; j < doubles.length; j++) {
			sum += doubles[j];
		}
		return sum;
	}

}
