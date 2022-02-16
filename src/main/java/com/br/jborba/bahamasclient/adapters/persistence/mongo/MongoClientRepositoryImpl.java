package com.br.jborba.bahamasclient.adapters.persistence.mongo;

import com.br.jborba.bahamasclient.application.domain.Client;
import com.br.jborba.bahamasclient.ports.outbound.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MongoClientRepositoryImpl implements ClientRepository {
    private final MongoClientRepository mongoClientRepository;

    @Autowired
    public MongoClientRepositoryImpl(@Lazy final MongoClientRepository mongoClientRepository) {
        this.mongoClientRepository = mongoClientRepository;
    }

    @Override
    public Client save(Client client) {
        return mongoClientRepository.save(client);
    }

    @Override
    public Optional<Client> getByInvoiceId(Long id) {
        return mongoClientRepository.findByInvoiceId(id);
    }
}
