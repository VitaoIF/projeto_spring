package com.estudandojava.curso.repositories;

import com.estudandojava.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
