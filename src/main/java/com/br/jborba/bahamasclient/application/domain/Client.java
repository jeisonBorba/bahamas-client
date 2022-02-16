package com.br.jborba.bahamasclient.application.domain;

import com.br.jborba.bahamasclient.application.exception.ClientInvalidException;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public class Client {
    public static final String VALID_EMAIL_ADDRESS_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private UUID id;
    private Long invoiceId;
    private Long fiscalId;
    private String name;
    private String email;

    public Client() {
    }

    public Client(Long invoiceId, Long fiscalId, String name, String email) {
        this.invoiceId = invoiceId;
        this.fiscalId = fiscalId;
        this.name = name;
        this.email = email;
    }

    public void validate() throws ClientInvalidException {
        this.validateId();
        this.validateInvoiceId();
        this.validateFiscalId();
        this.validateName();
        this.validateEmail();
    }

    private void validateId() throws ClientInvalidException {
        if (this.id == null) {
            throw new ClientInvalidException("Id must be provided");
        }
    }

    private void validateInvoiceId() throws ClientInvalidException {
        if (this.invoiceId == null || this.invoiceId <= 0) {
            throw new ClientInvalidException("Invoice id must be provided");
        }
    }

    private void validateFiscalId() throws ClientInvalidException {
        if (this.fiscalId == null || this.fiscalId <= 0) {
            throw new ClientInvalidException("Fiscal id must be provided");
        }
    }

    private void validateName() throws ClientInvalidException {
        if (this.name == null || this.name.isEmpty()) {
            throw new ClientInvalidException("Name must be provided");
        }
    }

    private void validateEmail() throws ClientInvalidException {
        if (this.email == null || this.email.isEmpty()) {
            throw new ClientInvalidException("Email must be provided");
        }
        boolean isEmailValid = Pattern.compile(VALID_EMAIL_ADDRESS_REGEX, Pattern.CASE_INSENSITIVE)
                .matcher(this.email)
                .matches();
        if (!isEmailValid) {
            throw new ClientInvalidException("The provided email is invalid");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(invoiceId, client.invoiceId) && Objects.equals(fiscalId, client.fiscalId) && Objects.equals(name, client.name) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceId, fiscalId, name, email);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceId=" + invoiceId +
                ", fiscalId=" + fiscalId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
