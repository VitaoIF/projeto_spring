package com.estudandojava.curso.services;

import com.estudandojava.curso.entities.Order;
import com.estudandojava.curso.repositories.OrderRepository;
import com.estudandojava.curso.services.exceptions.DatabaseException;
import com.estudandojava.curso.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> orderId = repository.findById(id);
        return orderId.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Order insert(Order order){
        return repository.save(order);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Order update(Long id, Order order){
        Order entity = repository.getReferenceById(id);
        updateOrder(entity, order);
        return repository.save(entity);
    }

    private void updateOrder(Order entity, Order order) {
        entity.setOrderStatus(order.getOrderStatus());
        entity.setPayment(order.getPayment());
        entity.setNow(order.getNow());
    }
}
