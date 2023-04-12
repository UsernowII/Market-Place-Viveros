package com.viveros.marketplace.repository;

import com.viveros.marketplace.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository {

    void create(Product product);

    List<Product> getProducts();
}
