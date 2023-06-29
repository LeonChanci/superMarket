package com.co.supermarket.persistence.crud;

import com.co.supermarket.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientCrudRepository extends CrudRepository<Cliente, String> {

    Optional<Cliente> findById(String id);

}
