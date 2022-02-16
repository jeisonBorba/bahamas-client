package com.br.jborba.bahamasclient.application.domain;

import com.br.jborba.bahamasclient.application.exception.ClientInvalidException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {

    @Test
    public void whenClientIsMissingInformationItShouldReturnException() {
        Client client = new Client();
        Exception exception = assertThrows(ClientInvalidException.class, client::validate);
        String receivedMessage = exception.getMessage();

        assertEquals("Id must be provided", receivedMessage);

        client.setId(UUID.randomUUID());
        exception = assertThrows(ClientInvalidException.class, client::validate);
        receivedMessage = exception.getMessage();

        assertEquals("Invoice id must be provided", receivedMessage);

        client.setInvoiceId(1234L);
        exception = assertThrows(ClientInvalidException.class, client::validate);
        receivedMessage = exception.getMessage();

        assertEquals("Fiscal id must be provided", receivedMessage);

        client.setFiscalId(12345L);
        exception = assertThrows(ClientInvalidException.class, client::validate);
        receivedMessage = exception.getMessage();

        assertEquals("Name must be provided", receivedMessage);
    }

    @Test
    public void whenClientContainsInvalidEmailItShouldReturnException() {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setInvoiceId(1234L);
        client.setFiscalId(12345L);
        client.setName("Test Mock");
        Exception exception = assertThrows(ClientInvalidException.class, client::validate);
        String receivedMessage = exception.getMessage();

        assertEquals("Email must be provided", receivedMessage);

        client.setEmail("test.com");
        exception = assertThrows(ClientInvalidException.class, client::validate);
        receivedMessage = exception.getMessage();

        assertEquals("The provided email is invalid", receivedMessage);
    }

    @Test
    public void whenClientIsValidItShouldBeValidated() {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setInvoiceId(1234L);
        client.setFiscalId(12345L);
        client.setName("Test Mock");
        client.setEmail("test@test.com");

        assertDoesNotThrow(client::validate);
    }
}
