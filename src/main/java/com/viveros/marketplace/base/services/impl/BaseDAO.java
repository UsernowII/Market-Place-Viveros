package com.viveros.marketplace.base.services.impl;

import com.viveros.marketplace.base.services.interfaces.IBaseDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class BaseDAO<E, R extends CrudRepository<E, Integer>> implements IBaseDAO<E> {

    protected final R repository;

    public BaseDAO(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public E save(E entity) {
        return this.repository.save(entity);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable <E> findAll() { return this.repository.findAll(); }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }
}
