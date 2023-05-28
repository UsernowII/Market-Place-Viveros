package com.viveros.marketplace.base.controllers;
import com.viveros.marketplace.base.services.interfaces.IBaseDAO;
import com.viveros.marketplace.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class BaseController <E, S extends IBaseDAO<E>> {

    protected final S service;
    protected String entityName;

    public BaseController(S service) {
        this.service = service;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @GetMapping
    public List<E> getAll(){
        System.out.println("from BaseController");
        List<E> entityList = (List<E>) service.findAll();
        if(entityList.isEmpty()) {
            throw new BadRequestException(
                    String.format("Data not available for %ss", entityName));
        }
        return entityList;
    }

}
