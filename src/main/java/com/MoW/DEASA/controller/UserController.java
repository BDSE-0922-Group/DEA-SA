package com.MoW.DEASA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MoW.DEASA.dto.UserRegistrationRequest;
import com.MoW.DEASA.entity.User;
import com.MoW.DEASA.enums.UserRole;
import com.MoW.DEASA.payload.LoginRequest;
import com.MoW.DEASA.service.UserService;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest request) {
        try {
            User registeredUser = userService.registerUser(
                    request.getUserName(),
                    request.getUserEmail(),
                    request.getUserPassword(),
                    request.getUserRole()
            );
            return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request) {
        User user = userService.findByUserEmail(request.getUserEmail());

        if (user == null || !userService.isPasswordValid(user, request.getUserPassword())) {
            return new ResponseEntity<>("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }

        String dashboardUrl = getDashboardUrl(user.getUserRole());
        return new ResponseEntity<>(dashboardUrl, HttpStatus.OK);
    }

    private String getDashboardUrl(UserRole userRole) {
        switch (userRole) {
            case ADMIN:
                return "Admin/admin-dashboard";
            case PARTNER:
                return "Partner/partner-dashboard";
            case DRIVER:
                return "Driver/driver-dashboard";
            case MEMBER_OR_CAREGIVER:
                return "Member/member-dashboard";
            case DONOR:
                return "Donator/donator-dashboard";
            default:
                return "Auth/login";
        }
    }
}

