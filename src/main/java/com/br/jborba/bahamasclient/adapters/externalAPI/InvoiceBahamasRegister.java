package com.br.jborba.bahamasclient.adapters.externalAPI;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "invoiceBahamasClient", url = "https://bahamas.gov/register/")
public interface InvoiceBahamasRegister {

    @RequestMapping(method = RequestMethod.POST)
    void register(
            @RequestParam("invoice") Long invoice,
            @RequestParam("fiscal_id") Long fiscalId,
            @RequestParam("name") String name,
            @RequestParam("email") String email);
}
