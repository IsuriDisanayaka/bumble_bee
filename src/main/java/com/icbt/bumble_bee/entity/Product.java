package com.icbt.bumble_bee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/15/2023
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Name is mandatory")
    private String name;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Brand Name is mandatory")
    private String brandName;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = " Category  is mandatory")
    private String category;

    @Column(columnDefinition = "VARCHAR(100)")
    @NotNull(message = "Description is mandatory")
    private String description;


    private BigDecimal price ;

    @CreationTimestamp
    @Column(columnDefinition = "DATETIME")
    private Date createdDate;


    @Column(columnDefinition = "TINYINT")
    @Value("${some.key:false}")
    private boolean isDeleted ;


}
