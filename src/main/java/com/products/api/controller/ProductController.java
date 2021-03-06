package com.products.api.controller;

import com.products.api.dto.ProductDTO;
import com.products.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping(value = "/product")
    public ProductDTO saveProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @DeleteMapping(value = "/product")
    public void deleteProduct(@RequestBody ProductDTO productDTO) {
        productService.deleteProduct(productDTO);
    }

    @PutMapping("/product")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

}
