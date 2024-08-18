package com.godiegogo.apirest.theapirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.godiegogo.apirest.theapirest.Entities.Product;

public interface ProductRepository extends JpaRepository <Product, Long> {
    
}
