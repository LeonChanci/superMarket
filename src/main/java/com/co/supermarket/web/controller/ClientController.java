package com.co.supermarket.web.controller;

import com.co.supermarket.domain.Client;
import com.co.supermarket.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Obtener todos las Clientes")
    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getALl(), HttpStatus.OK);
    }

    @Operation(summary = "Obtener un Cliente con la Identificación")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") String id){
        return clientService.getById(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Operation(summary = "Guardar un objeto Cliente")
    @PostMapping("/save")
    //@RequestBody -> Para determinar que el parámetro es parte del cuerpo de la petición (hace parte del Body->row)
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }
}
