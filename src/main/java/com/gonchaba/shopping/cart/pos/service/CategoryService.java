package com.gonchaba.shopping.cart.pos.service;


import com.gonchaba.shopping.cart.pos.dto.CategoryDTO;
import com.gonchaba.shopping.cart.pos.entity.Category;

import java.util.List;

public interface CategoryService {

   List<CategoryDTO> getAll();

   Category getOne(Long id);

    CategoryDTO add(CategoryDTO obj);

   void delete(Long id);

}
