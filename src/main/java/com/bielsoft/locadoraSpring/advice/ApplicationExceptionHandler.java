package com.bielsoft.locadoraSpring.advice;

import com.bielsoft.locadoraSpring.exceptions.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FabricanteExistenteException.class)
    public ResponseEntity<String> handlerExceptionFabricanteExiste(FabricanteExistenteException ex){
        log.info("FABRICANTE JA EXISTE!");
        return new ResponseEntity<>("FABRICANTE JA EXISTE!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ModeloExisteException.class)
    public ResponseEntity<String> handlerExceptionModeloExiste(ModeloExisteException ex){
        log.info("MODELO JA EXISTE!");
        return new ResponseEntity<>("MODELO JA EXISTE!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlacaExistenteException.class)
    public ResponseEntity<String> handlerExceptionPlacaExistente(PlacaExistenteException ex){
        return new ResponseEntity<>("PLACA JA EXISTE!", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FabricanteNaoEncontradoException.class)
    public ResponseEntity<String> handlerExceptionFabricanteNaoEncontrado(FabricanteNaoEncontradoException ex){
        return new ResponseEntity<>("FABRICANTE NAO ENCONTRADO", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ModeloNaoEncontradoException.class)
    public ResponseEntity<String> handlerExceptionModeloNaoEncontrado(ModeloNaoEncontradoException ex){
        return new ResponseEntity<>("MODELO NAO ENCONTRADO", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CarroIdNaoEncontradoException.class)
    public ResponseEntity<String> handlerExceptionCarroIdNaoEncontrado(CarroIdNaoEncontradoException ex){
        return new ResponseEntity<>("ID NAO ENCONTRADO", HttpStatus.NOT_FOUND);
    }


}
