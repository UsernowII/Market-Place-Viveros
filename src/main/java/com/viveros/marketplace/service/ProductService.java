package com.viveros.marketplace.service;

import com.viveros.marketplace.models.Product;
import com.viveros.marketplace.repository.IProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ProductService implements IProductRepository {

    @PersistenceContext
    EntityManager entityManager;



    @Override
    public void create(Product product) {
       entityManager.persist(product);
    }

    @Override
    public List<Product> getProducts() {
        String query = "From Product";
        return (List<Product>) entityManager.createQuery(query).getResultList();
    }
}
