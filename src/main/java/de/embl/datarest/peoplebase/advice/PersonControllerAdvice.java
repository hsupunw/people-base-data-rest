package de.embl.datarest.peoplebase.advice;

import de.embl.datarest.peoplebase.exception.MandatoryFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PersonControllerAdvice {
    @ResponseBody
    @ExceptionHandler(MandatoryFieldException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Error handleMandatoryField(MandatoryFieldException ex) {
        return new Error(ex.getMessage());
    }
}
