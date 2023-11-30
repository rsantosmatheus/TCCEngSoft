package com.TCC.gerenciamentoEstoque.domain.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class CustomException extends RuntimeException {

    private ResponseEntity<?> responseEntity;

    public CustomException(String message,  ResponseEntity<?> responseEntity) {
        super(message);
        this.responseEntity = responseEntity;
    }

    public ResponseEntity<?> getResponseEntity() {
        return responseEntity;
    }

    public CustomException(String message){
        super(message);
    }
}
