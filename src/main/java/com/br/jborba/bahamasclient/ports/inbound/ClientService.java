package com.br.jborba.bahamasclient.ports.inbound;

import com.br.jborba.bahamasclient.application.domain.Client;
import com.br.jborba.bahamasclient.application.dto.ClientDTO;
import com.br.jborba.bahamasclient.application.exception.ClientInvalidException;

public interface ClientService {
    ClientDTO storeClient(Client client) throws ClientInvalidException;
    ClientDTO retrieveByInvoiceId(Long invoiceId);
}
