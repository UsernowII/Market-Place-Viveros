package com.viveros.marketplace.base;


import com.viveros.marketplace.base.entities.BaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring")
public interface BaseDTO {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "createdAt", target = "created_at"),
            @Mapping(source = "updatedAt", target = "updatedAt"),



    })
    BaseDTO baseMapper(BaseEntity baseEntity);
}
