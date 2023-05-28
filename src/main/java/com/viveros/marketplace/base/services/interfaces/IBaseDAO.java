package com.viveros.marketplace.base.services.interfaces;

import java.util.Optional;

public interface IBaseDAO<E> {

    Optional<E> findById(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);

}
