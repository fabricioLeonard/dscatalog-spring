package com.fabricioleonard.dscatalog.service;

import com.fabricioleonard.dscatalog.dto.CategoryDTO;
import com.fabricioleonard.dscatalog.entity.Category;
import com.fabricioleonard.dscatalog.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll();
        return list.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());
    }

}