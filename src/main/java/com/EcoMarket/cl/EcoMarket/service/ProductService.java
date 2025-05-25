package com.EcoMarket.cl.EcoMarket.service;

import com.EcoMarket.cl.EcoMarket.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> update(Long id, Product productDetails);
    void deleteById(Long id);
    boolean existsById(Long id);
}
