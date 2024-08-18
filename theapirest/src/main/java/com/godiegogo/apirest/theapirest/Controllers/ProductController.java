package com.godiegogo.apirest.theapirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.godiegogo.apirest.theapirest.Repositories.ProductRepository;
import com.godiegogo.apirest.theapirest.Entities.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
    // Addresses and URLS

    @Autowired // Springs knows what repositry is the chosen, JPA brings all the configurations to get the Data Base.
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the ID " + id + " doesn't exist"));
    }

    @PutMapping
    public Product updateProduct(@PathVariable Long id, @RequestBody Product detailProduct) {

        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the ID " + id + " doesn't exist"));

        product.setName(detailProduct.getName());
        product.setPrice(detailProduct.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping
    public String deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("The product with the ID " + id + " doesn't exist"));

        productRepository.delete(product);
        return "Product with ID " + id + " deleted";
    }


}
