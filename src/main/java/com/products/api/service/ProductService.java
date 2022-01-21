package com.products.api.service;

import com.products.api.dto.ProductDTO;
import com.products.api.entities.Product;
import com.products.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductDTO::new);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        if (productRepository.findById(id).isPresent()) {
            Product product = productRepository.findById(id).get();
            return new ProductDTO(product);
        }
        return null;
    }

    @Transactional
    public ProductDTO saveProduct(ProductDTO productDTO) {
        Product product = new Product();

        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setQuantity(productDTO.getQuantity());
        product.setValue(productDTO.getValue());

        product = productRepository.save(product);

        return new ProductDTO(product);

    }
}
