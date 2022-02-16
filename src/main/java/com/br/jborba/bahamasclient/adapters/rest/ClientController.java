package com.br.jborba.bahamasclient.adapters.rest;

import com.br.jborba.bahamasclient.application.domain.Client;
import com.br.jborba.bahamasclient.application.dto.ClientDTO;
import com.br.jborba.bahamasclient.application.mapper.ClientMapper;
import com.br.jborba.bahamasclient.application.exception.ClientInvalidException;
import com.br.jborba.bahamasclient.ports.inbound.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private final ClientService clientService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    public ClientController(final ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/store-bahamas-client/{invoiceId}")
    public ResponseEntity<ClientDTO> store(
            @PathVariable("invoiceId") final Long invoiceId,
            @RequestParam("fiscalId") final Long fiscalId,
            @RequestParam("name") final String name,
            @RequestParam("email") final String email) throws ClientInvalidException {
        Client client = ClientMapper.dataToClient(invoiceId, fiscalId, name, email);

        LOGGER.info("Received request to store new client: [{}]", client);

        ClientDTO clientCreated = clientService.storeClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientCreated);
    }

    @GetMapping("/retrieve-bahamas-client/{invoiceId}")
    public ResponseEntity<ClientDTO> retrieve(@PathVariable("invoiceId") final Long invoiceId) {
        ClientDTO clientDTO = clientService.retrieveByInvoiceId(invoiceId);

        LOGGER.info("Received request to retrieve client: [{}]", clientDTO);

        if (clientDTO.getInvoiceId() == null) {
            LOGGER.info("No client found with invoiveId: [{}]", clientDTO.getInvoiceId());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientDTO);
    }
}
