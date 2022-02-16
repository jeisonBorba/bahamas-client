package com.br.jborba.bahamasclient.application.exception;

import java.io.Serializable;

public class ClientInvalidException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public ClientInvalidException() {}

    public ClientInvalidException(String message) {
        super(message);
    }

    public ClientInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
