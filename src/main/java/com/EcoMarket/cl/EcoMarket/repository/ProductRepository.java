package com.EcoMarket.cl.EcoMarket.repository;

import com.EcoMarket.cl.EcoMarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Repositorio
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    List<Product> findByPrice(Integer price);

    List<Product> findByStock(Integer stock);
}
