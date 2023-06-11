package com.alkemy.gestordealumnos.exceptions;
import com.alkemy.gestordealumnos.exceptions.errorMensajes.ErrorMensaje;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;


public class NoEncontradoException extends RuntimeException {

    public NoEncontradoException(ErrorMensaje errorMsj) {
        super(String.valueOf(errorMsj));
    }


    @ExceptionHandler(NoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoEncontradoException(NoEncontradoException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("mensaje", ex.getMessage());
        return errorResponse;
    }

}
