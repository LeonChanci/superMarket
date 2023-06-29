package com.co.supermarket.persistence;

import com.co.supermarket.domain.Client;
import com.co.supermarket.domain.repository.ClientRepository;
import com.co.supermarket.persistence.crud.ClientCrudRepository;
import com.co.supermarket.persistence.entity.Cliente;
import com.co.supermarket.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public List<Client> getAll() {
        return mapper.toClients((List<Cliente>) clientCrudRepository.findAll());
    }

    @Override
    public Optional<Client> getById(String id) {
        return clientCrudRepository.findById(id)
                .map(client -> mapper.toClient(client));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clientCrudRepository.save(cliente));
    }

}
