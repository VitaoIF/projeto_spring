package com.estudandojava.curso.services;

import com.estudandojava.curso.entities.User;
import com.estudandojava.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> resultado = repository.findById(id);
        return resultado.get();
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User entity = repository.getReferenceById(id);
        udpateData(entity, user);
        return repository.save(entity);
    }

    private void udpateData(User entity, User user) {
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }


}
