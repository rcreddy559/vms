package com.vms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vms.service.ResidentService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    ResidentService residentService;

    public LoginController(ResidentService residentService) {
        this.residentService = residentService;
    }
    
    @PostMapping("/send-otp")
    public String sendOtp(String phoneNumber) {
        residentService.validatePhoneNumber(phoneNumber);
        return "OTP sent to " + phoneNumber;
    }
    
    @PostMapping("/authenticate")
    public String authenticate(String phoneNumber, String otp) {
        // Logic for authentication
       
        return "Authenticated";
    }
    @PostMapping("/register")
    public String register(String name, String phoneNumber, String email) {
        // Logic for registration
        return "Registered";
    }
    @PostMapping("/forgot-password")
    public String forgotPassword( String email) {
        // Logic for forgot password
        return "Password reset link sent";
    }
    @PostMapping("/reset-password")
    public String resetPassword() {
        // Logic for resetting password
        return "Password reset successfully";
    }
    @PostMapping("/logout")
    public String logout() {
        // Logic for logout
        return "Logged out successfully";
    }
    @PostMapping("/change-password")
    public String changePassword() {
        // Logic for changing password
        return "Password changed successfully";
    }
    @PostMapping("/update-profile")
    public String updateProfile() {
        // Logic for updating profile
        return "Profile updated successfully";
    }
}
