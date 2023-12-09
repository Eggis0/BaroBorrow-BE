package com.example.subsub.controller;

import com.example.subsub.dto.request.UpdateUserCertifiRequest;
import com.example.subsub.dto.request.UpdateUserRequest;
import com.example.subsub.dto.response.RegisterResponse;
import com.example.subsub.dto.request.UserRequest;
import com.example.subsub.dto.response.UserResponse;
import com.example.subsub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<UserResponse> signin(@RequestBody UserRequest request) throws Exception {
        return userService.login(request);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> signup(@RequestBody UserRequest request) throws Exception {
        return userService.register(request);
    }

    @GetMapping("/user/get")
    public ResponseEntity<UserResponse> getUser(@RequestParam String id) throws Exception {
        return userService.getUser(id);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<UserResponse> getUserForAdmin(@RequestParam String id) throws Exception {
        return userService.getUser(id);
    }

    @PutMapping("/admin/user/certification")
    public ResponseEntity<UserResponse>  updateCertification(@RequestParam String id,@RequestBody UpdateUserCertifiRequest request) {
        return userService.updateCertification(id, request);
    }
    @PutMapping("/user/update")
    public ResponseEntity<UserResponse>  updateNickname(@RequestBody UpdateUserRequest request, Authentication authentication) {
        return userService.updateNickname(authentication.getName(), request);
    }


}