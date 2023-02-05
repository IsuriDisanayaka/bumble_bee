package com.icbt.bumble_bee.exception;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
public class ValidateException extends RuntimeException {
    public ValidateException (String message){
        super(message);
    }
}
