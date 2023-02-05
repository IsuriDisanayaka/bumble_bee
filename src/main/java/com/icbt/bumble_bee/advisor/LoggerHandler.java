package com.icbt.bumble_bee.advisor;

import com.icbt.bumble_bee.util.StandardLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/

@RestControllerAdvice
public class LoggerHandler {
    private static Logger logger= LoggerFactory.getLogger(LoggerHandler.class);

    public static LoggerHandler handlerLogger(StandardLogger standardLogger){
        switch (standardLogger.getType()) {
            case "error":
                logger.error(standardLogger.getMessage());
                break;
            case "warn":
                logger.warn(standardLogger.getMessage());
                break;
            case "info":
                logger.info(standardLogger.getMessage());
                break;
            case "debug":
                logger.debug(standardLogger.getMessage());
                break;
            case "trace":
                logger.trace(standardLogger.getMessage());
                break;
        }
        return null;

    }

}
