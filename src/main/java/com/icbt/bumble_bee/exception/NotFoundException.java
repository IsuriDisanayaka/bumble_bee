package com.icbt.bumble_bee.exception;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
public class NotFoundException extends RuntimeException{
    public NotFoundException (String message){
        super(message);
    }

}
