package com.br.jborba.bahamasclient.application.services;

import com.br.jborba.bahamasclient.adapters.externalAPI.InvoiceBahamasRegister;
import com.br.jborba.bahamasclient.application.domain.Client;
import com.br.jborba.bahamasclient.application.dto.ClientDTO;
import com.br.jborba.bahamasclient.application.exception.ClientInvalidException;
import com.br.jborba.bahamasclient.ports.outbound.ClientRepository;
import com.br.jborba.bahamasclient.ports.outbound.InvoiceRegister;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ClientServiceImplTest {
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private InvoiceRegister invoiceBahamasRegister;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);

        this.clientService = new ClientServiceImpl(clientRepository, invoiceBahamasRegister);
    }

    private Client getValidClient() {
        Client client = new Client();
        client.setInvoiceId(1234L);
        client.setFiscalId(12345L);
        client.setName("Test");
        client.setEmail("teste@test.com");

        return client;
    }

    @Test
    public void whenCallStoreMethodItShouldCreateNewClient() throws ClientInvalidException {
        Client client = getValidClient();

        Mockito.when(clientRepository.save(client)).thenReturn(client);
        Mockito.doNothing().when(invoiceBahamasRegister).register(
                client.getInvoiceId(),
                client.getFiscalId(),
                client.getName(),
                client.getEmail()
        );

        ClientDTO expectedClient = clientService.storeClient(client);

        Mockito.verify(clientRepository, Mockito.times(1)).save(client);
        Mockito.verify(invoiceBahamasRegister, Mockito.times(1)).register(
                client.getInvoiceId(),
                client.getFiscalId(),
                client.getName(),
                client.getEmail()
        );
        assertNotNull(client.getId());
        assertEquals(expectedClient.getInvoiceId(), client.getInvoiceId());
        assertEquals(expectedClient.getFiscalId(), client.getFiscalId());
        assertEquals(expectedClient.getName(), client.getName());
        assertEquals(expectedClient.getEmail(), client.getEmail());
    }

    @Test
    public void whenCallRetrieveMethodAndNoClientFoundItShouldReturnEmptyObject() {
        Mockito.when(clientRepository.getByInvoiceId(Mockito.anyLong())).thenReturn(Optional.ofNullable(Mockito.any(Client.class)));

        ClientDTO expectedClient = clientService.retrieveByInvoiceId(1234L);

        Mockito.verify(clientRepository, Mockito.times(1)).getByInvoiceId(Mockito.anyLong());
        assertNull(expectedClient.getInvoiceId());
    }

    @Test
    public void whenCallRetrieveMethodItShouldReturnClient() {
        Long invoiceId = 1234L;
        Client client = getValidClient();
        Mockito.when(clientRepository.getByInvoiceId(Mockito.anyLong())).thenReturn(Optional.of(client));

        ClientDTO expectedClient = clientService.retrieveByInvoiceId(invoiceId);

        Mockito.verify(clientRepository, Mockito.times(1)).getByInvoiceId(Mockito.anyLong());
        assertEquals(expectedClient.getInvoiceId(), invoiceId);
    }
}
