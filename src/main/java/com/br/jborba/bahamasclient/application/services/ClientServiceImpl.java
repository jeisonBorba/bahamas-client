package com.br.jborba.bahamasclient.application.services;

import com.br.jborba.bahamasclient.adapters.externalAPI.InvoiceBahamasRegister;
import com.br.jborba.bahamasclient.application.domain.Client;
import com.br.jborba.bahamasclient.application.dto.ClientDTO;
import com.br.jborba.bahamasclient.application.mapper.ClientMapper;
import com.br.jborba.bahamasclient.application.exception.ClientInvalidException;
import com.br.jborba.bahamasclient.ports.inbound.ClientService;
import com.br.jborba.bahamasclient.ports.outbound.ClientRepository;
import com.br.jborba.bahamasclient.ports.outbound.InvoiceRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final InvoiceRegister invoiceBahamasRegister;

    @Autowired
    public ClientServiceImpl(final ClientRepository clientRepository, final InvoiceRegister invoiceBahamasRegister) {
        this.clientRepository = clientRepository;
        this.invoiceBahamasRegister = invoiceBahamasRegister;
    }

    @Override
    public ClientDTO storeClient(Client client) throws ClientInvalidException {
        client.setId(UUID.randomUUID());
        client.validate();

        Client recordedClient = clientRepository.save(client);

        invoiceBahamasRegister.register(
                client.getInvoiceId(),
                client.getFiscalId(),
                client.getName(),
                client.getEmail());

        return ClientMapper.toClientDTO(recordedClient);
    }

    @Override
    public ClientDTO retrieveByInvoiceId(Long invoiceId) {
        Optional<Client> client = clientRepository.getByInvoiceId(invoiceId);
        return client.map(ClientMapper::toClientDTO).orElse(new ClientDTO());
    }
}
