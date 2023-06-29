package com.co.supermarket.domain.repository;

import com.co.supermarket.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();

    Optional<Client> getById(String id);

    Client save(Client client);
}
