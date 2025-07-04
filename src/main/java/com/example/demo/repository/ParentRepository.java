package com.example.demo.repository;

import com.example.demo.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
    Parent findByUsername(String username);
} 