package com.example.ferreteria.controller;

import com.example.ferreteria.model.ProductModel;
import com.example.ferreteria.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public ProductModel getProductById(@PathVariable long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    @PostMapping
    public ProductModel createProduct(@RequestBody ProductModel product) {
        return productRepository.save(product);
    }

    @PutMapping("/{id}")
    public ProductModel updateProduct(@PathVariable long id, @RequestBody ProductModel updatedProduct) {
        ProductModel existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());

        return productRepository.save(existingProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productRepository.deleteById(id);
    }
}
