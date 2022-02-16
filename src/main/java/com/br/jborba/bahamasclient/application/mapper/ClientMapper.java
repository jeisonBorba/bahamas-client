package com.br.jborba.bahamasclient.application.mapper;

import com.br.jborba.bahamasclient.application.domain.Client;
import com.br.jborba.bahamasclient.application.dto.ClientDTO;

public class ClientMapper {
    public static Client dataToClient(Long invoiceId, Long fiscalId, String name, String email) {
        return new Client(invoiceId, fiscalId, name, email);
    }

    public static ClientDTO toClientDTO(Client client) {
        return new ClientDTO(
                client.getInvoiceId(),
                client.getFiscalId(),
                client.getName(),
                client.getEmail());
    }
}
