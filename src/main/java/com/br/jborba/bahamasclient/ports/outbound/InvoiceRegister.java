package com.br.jborba.bahamasclient.ports.outbound;

public interface InvoiceRegister {
    void register(Long invoiceId, Long fiscalId, String name, String email);
}
