package com.br.jborba.bahamasclient.adapters.externalAPI;

import com.br.jborba.bahamasclient.ports.outbound.InvoiceRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class InvoiceRegisterMock implements InvoiceRegister {
    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceRegisterMock.class);

    @Override
    public void register(Long invoiceId, Long fiscalId, String name, String email) {
        LOGGER.info("Mocking invoice register invoiceId: {}, ficalId: {}, name: {}, email: {}",
                invoiceId, fiscalId, name, email);
    }
}
