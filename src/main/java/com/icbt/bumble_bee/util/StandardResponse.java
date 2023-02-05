package com.icbt.bumble_bee.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/3/2023
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private int code;
    private String message;
    private Object data;
}
