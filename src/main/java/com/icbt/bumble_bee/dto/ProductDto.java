package com.icbt.bumble_bee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/15/2023
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto implements SuperDto{
    private int id;
    private String imageUrl;
    private String name;
    private String brandName;
    private String category;
    private String description;
    private BigDecimal price ;
    private Date createdDate;
    private boolean isDeleted ;

}
