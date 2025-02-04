package com.devsuperior.curso.desafio03.services;

import com.devsuperior.curso.desafio03.dtos.ClientDTO;
import com.devsuperior.curso.desafio03.entities.Client;
import com.devsuperior.curso.desafio03.repositories.ClientRepository;
import com.devsuperior.curso.desafio03.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = repository.findAll(pageable);
        return clients.map(ClientDTO::new);
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional
    public ClientDTO insert(ClientDTO clientDTO) {
        Client client = new Client();
        convertClientDtoToEntity(clientDTO, client);
        return new ClientDTO(repository.save(client));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO clientDTO) {
        try {
            Client client = repository.getReferenceById(id);
            convertClientDtoToEntity(clientDTO, client);

            return new ClientDTO(repository.save(client));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    private void convertClientDtoToEntity(ClientDTO clientDTO, Client client) {
        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setIncome(clientDTO.getIncome());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
    }
}
