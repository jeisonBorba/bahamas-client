package com.br.jborba.bahamasclient.adapters.configuration.persistence;

import com.br.jborba.bahamasclient.BahamasClientApplication;
import com.br.jborba.bahamasclient.adapters.externalAPI.InvoiceBahamasRegister;
import com.br.jborba.bahamasclient.application.services.ClientServiceImpl;
import com.br.jborba.bahamasclient.ports.inbound.ClientService;
import com.br.jborba.bahamasclient.ports.outbound.ClientRepository;
import com.br.jborba.bahamasclient.ports.outbound.InvoiceRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BahamasClientApplication.class)
public class BeanConfiguration {

    @Bean
    ClientService clientService(final ClientRepository clientRepository, final InvoiceRegister invoiceBahamasRegister) {
        return new ClientServiceImpl(clientRepository, invoiceBahamasRegister);
    }
}
