package com.estudandojava.curso.services;

import com.estudandojava.curso.entities.Category;
import com.estudandojava.curso.repositories.CategoryRepository;
import com.estudandojava.curso.services.exceptions.DatabaseException;
import com.estudandojava.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return categoryId.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Category insert(Category category){
        return categoryRepository.save(category);
    }

    public void delete(Long id){
        try {
            categoryRepository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Category update(Long id, Category category){
        try {
            Category entity = categoryRepository.getReferenceById(id);
            updateCategory(entity, category);
            return categoryRepository.save(entity);
        } catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateCategory(Category entity, Category category) {
        entity.setName(category.getName());
    }
}
