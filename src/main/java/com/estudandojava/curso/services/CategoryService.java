package com.estudandojava.curso.services;

import com.estudandojava.curso.entities.Category;
import com.estudandojava.curso.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> categoryId = categoryRepository.findById(id);
        return categoryId.get();
    }
}
