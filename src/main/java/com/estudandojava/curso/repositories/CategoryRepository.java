package com.estudandojava.curso.repositories;

import com.estudandojava.curso.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
