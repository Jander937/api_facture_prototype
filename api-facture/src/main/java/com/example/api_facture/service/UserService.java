package com.example.api_facture.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public class UserService {
    ResponseEntity<String> signUp(Map<String, String> requestMap);

    ResponseEntity<String> login(Map<String, String> requestMap);
}
