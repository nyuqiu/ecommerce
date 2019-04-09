package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    private CartRepository repository;


}
