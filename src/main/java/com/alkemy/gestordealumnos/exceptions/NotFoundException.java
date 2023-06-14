package com.alkemy.gestordealumnos.exceptions;
import com.alkemy.gestordealumnos.exceptions.errorMenssage.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.HashMap;
import java.util.Map;


public class NotFoundException extends RuntimeException {

    public NotFoundException(ErrorMessage errorMsj) {
        super(String.valueOf(errorMsj));
    }


    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleNoEncontradoException(NotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("message", ex.getMessage());
        return errorResponse;
    }

}
