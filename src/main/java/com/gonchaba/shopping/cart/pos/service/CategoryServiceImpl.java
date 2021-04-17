package com.gonchaba.shopping.cart.pos.service;

import com.gonchaba.shopping.cart.pos.dto.CategoryDTO;
import com.gonchaba.shopping.cart.pos.entity.Category;
import com.gonchaba.shopping.cart.pos.mappers.CategoryDtoMapper;
import com.gonchaba.shopping.cart.pos.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class   CategoryServiceImpl implements CategoryService{

    private  final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAll() {
       return
        categoryRepository.findAll().parallelStream().map(CategoryDtoMapper.INSTANCE::dto
        ).collect(Collectors.toList());

        /*categoryRepository.findAll().forEach(category -> {
            CategoryDTO dto = new CategoryDTO();
            dto.setCategoryName(category.getTitle());
            dto.setDesc(category.getDescription());
            categoryDTOS.add(dto);
        } );*/
    }

    @Override
    public Category getOne(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public CategoryDTO add(CategoryDTO obj) {
        Category category = new Category();
        category.setDescription(obj.getDesc());
        category.setTitle(obj.getCategoryName());
        category.setStatus(true);
        Category savedCategory = categoryRepository.save(category);
        CategoryDTO savedDTO = new CategoryDTO();
        savedDTO.setCategoryName(savedCategory.getTitle());
        savedDTO.setDesc(savedCategory.getDescription());
        return savedDTO;
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }


}
