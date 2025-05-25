package com.EcoMarket.cl.EcoMarket.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Product { // MODELO

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 100,nullable = false)
    private String name;

    @Column (nullable = false)
    private Integer price;

    @Column (nullable = false)
    private Integer stock;

}
