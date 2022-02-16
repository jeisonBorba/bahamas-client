package com.br.jborba.bahamasclient.ports.outbound;

import com.br.jborba.bahamasclient.application.domain.Client;

import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    Optional<Client> getByInvoiceId(Long id);
}
