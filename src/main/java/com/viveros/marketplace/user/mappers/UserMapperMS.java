package com.viveros.marketplace.user.mappers;

import com.viveros.marketplace.base.BaseDTO;
import com.viveros.marketplace.base.mapper.BaseMapperConfig;
import com.viveros.marketplace.user.dto.UserDTO;
import com.viveros.marketplace.user.entities.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapperMS extends BaseMapperConfig {

    @Mappings(value = {
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "id", target = "id")

    })
    @InheritConfiguration(name = "baseMapper")
    UserDTO userMapper(User user, @MappingTarget BaseDTO baseDTO);
}
