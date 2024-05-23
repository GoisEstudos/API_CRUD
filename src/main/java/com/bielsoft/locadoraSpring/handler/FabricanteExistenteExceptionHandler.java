package com.bielsoft.locadoraSpring.handler;

import com.bielsoft.locadoraSpring.DTO.FabricanteExistenteExceptionDTO;
import com.bielsoft.locadoraSpring.exceptions.FabricanteExistenteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FabricanteExistenteExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(FabricanteExistenteException.class)
    public FabricanteExistenteExceptionDTO fabricanteExistenteExceptionDTO(FabricanteExistenteException fee) {
        return new FabricanteExistenteExceptionDTO(fee.getMessage());
    }

}
