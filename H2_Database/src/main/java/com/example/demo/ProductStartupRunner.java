package com.example.demo;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProductStartupRunner {

    private static final Logger logger = LoggerFactory.getLogger(ProductStartupRunner.class);

    @Bean
    public CommandLineRunner commandLineRunner(ProductService productService) {
        return args -> {
            logger.info("CommandLineRunner: Seeding initial data...");
            productService.addProduct(new Product(null, "Laptop", 1500.00));
            productService.addProduct(new Product(null, "Smartphone", 800.00));
        };
    }

    @Bean
    public ApplicationRunner applicationRunner(ProductService productService) {
        return args -> {
            logger.info("ApplicationRunner: Additional startup tasks...");
            productService.addProduct(new Product(null, "Tablet", 600.00));
        };
    }
}
