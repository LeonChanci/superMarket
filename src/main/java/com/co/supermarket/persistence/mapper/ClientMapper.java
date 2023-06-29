package com.co.supermarket.persistence.mapper;

import com.co.supermarket.domain.Client;
import com.co.supermarket.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "identificacion", target = "id"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "celular", target = "cellPhone"),
            @Mapping(source = "direccion", target = "address"),
            @Mapping(source = "correoElectronico", target = "email")
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compras", ignore = true)
    })
    Cliente toCliente(Client client);

}
