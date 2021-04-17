package com.gonchaba.shopping.cart.pos.mappers;

import com.gonchaba.shopping.cart.pos.dto.CategoryDTO;
import com.gonchaba.shopping.cart.pos.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryDtoMapper {

    CategoryDtoMapper INSTANCE= Mappers.getMapper(CategoryDtoMapper.class);

    @Mappings(
            {
           @Mapping(source = "obj.title", target = "categoryName"),
            @Mapping(source = "obj.description", target = "desc")
            }
    )
    CategoryDTO dto (Category obj);
}
