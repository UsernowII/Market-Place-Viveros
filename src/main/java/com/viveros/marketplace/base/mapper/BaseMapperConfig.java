package com.viveros.marketplace.base.mapper;

import com.viveros.marketplace.base.BaseDTO;
import com.viveros.marketplace.base.entities.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface BaseMapperConfig {
    void baseMapper(BaseEntity baseEntity, @MappingTarget BaseDTO baseDTO);
}
