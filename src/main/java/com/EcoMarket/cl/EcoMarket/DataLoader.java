package com.EcoMarket.cl.EcoMarket;

import com.EcoMarket.cl.EcoMarket.model.Product;
import com.EcoMarket.cl.EcoMarket.repository.ProductRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dev")
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();

        // Verificar si ya existen productos para no duplicar datos
        if (productRepository.count() == 0) {
            // Generar 10 productos de prueba
            for (int i = 0; i < 10; i++) {
                Product product = new Product();
                product.setName(faker.commerce().productName());
                // Generación directa de precio como Integer
                product.setPrice(faker.number().numberBetween(1000, 10000)); // Precio entre 1000 y 10000
                product.setStock(faker.number().numberBetween(1, 100));

                productRepository.save(product);
            }
            System.out.println("Se han generado 10 productos de prueba");
        }
    }
}