package com.br.jborba.bahamasclient.application.dto;

public class ClientDTO {
    private Long invoiceId;
    private Long fiscalId;
    private String name;
    private String email;

    public ClientDTO() {
    }

    public ClientDTO(Long invoiceId, Long fiscalId, String name, String email) {
        this.invoiceId = invoiceId;
        this.fiscalId = fiscalId;
        this.name = name;
        this.email = email;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Long getFiscalId() {
        return fiscalId;
    }

    public void setFiscalId(Long fiscalId) {
        this.fiscalId = fiscalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "invoiceId=" + invoiceId +
                ", fiscalId=" + fiscalId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
