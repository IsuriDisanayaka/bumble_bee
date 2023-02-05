package com.icbt.bumble_bee.advisor;

import com.icbt.bumble_bee.exception.NotFoundException;
import com.icbt.bumble_bee.exception.ValidateException;
import com.icbt.bumble_bee.util.StandardResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException (Exception e){
        return new ResponseEntity(new StandardResponse(500,"Error",e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new StandardResponse(404, "Error", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateException.class)
    public  ResponseEntity handleValidationException (ValidateException e){
        return new ResponseEntity(new StandardResponse(400,"Error",e.getMessage()),HttpStatus.BAD_REQUEST);
    }
}
