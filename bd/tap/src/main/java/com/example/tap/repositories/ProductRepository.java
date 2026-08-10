package com.example.tap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tap.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
