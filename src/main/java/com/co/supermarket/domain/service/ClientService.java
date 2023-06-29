package com.co.supermarket.domain.service;

import com.co.supermarket.domain.Client;
import com.co.supermarket.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getALl(){
        return clientRepository.getAll();
    }

    public Optional<Client> getById(String id){
        return clientRepository.getById(id);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

}
