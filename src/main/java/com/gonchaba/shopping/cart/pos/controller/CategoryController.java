package com.gonchaba.shopping.cart.pos.controller;

import com.gonchaba.shopping.cart.pos.dto.CategoryDTO;
import com.gonchaba.shopping.cart.pos.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> categoryList(){
        return categoryService.getAll();
    }
   @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO dto)
   {
       return categoryService.add(dto);
    }


}
