package com.br.jborba.bahamasclient.adapters.persistence.mongo;

import com.br.jborba.bahamasclient.application.domain.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MongoClientRepository extends MongoRepository<Client, UUID> {
    Optional<Client> findByInvoiceId(Long id);
}
