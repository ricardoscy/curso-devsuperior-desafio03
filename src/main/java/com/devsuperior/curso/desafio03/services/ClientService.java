package com.devsuperior.curso.desafio03.services;

import com.devsuperior.curso.desafio03.dtos.ClientDTO;
import com.devsuperior.curso.desafio03.entities.Client;
import com.devsuperior.curso.desafio03.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }
}
