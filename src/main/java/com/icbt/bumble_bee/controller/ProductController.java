package com.icbt.bumble_bee.controller;

import com.icbt.bumble_bee.dto.ProductDto;
import com.icbt.bumble_bee.exception.NotFoundException;
import com.icbt.bumble_bee.repo.ProductRepo;
import com.icbt.bumble_bee.service.ProductService;
import com.icbt.bumble_bee.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Isuri Disanayaka <isuriumeshika1@gmail.com>
 * @since 2/17/2023
 **/
@RestController
@CrossOrigin
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto) {
        String productName = productService.saveProduct(productDto);
        return new ResponseEntity(new StandardResponse(200, "Done", productName), HttpStatus.CREATED);
    }
    @GetMapping(path = "/{type}/{input}")
    public ResponseEntity Search(@PathVariable("type")String type,@PathVariable("input") String input) {
        List<ProductDto> search =productService.searchProduct(type,input);
        return new ResponseEntity(new StandardResponse(200, "Done", search), HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity getAllProducts(){
        ArrayList<ProductDto> getAllProducts = productService.getProducts();

        return new ResponseEntity(new StandardResponse(200,"Done",getAllProducts),HttpStatus.OK);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        boolean done = productService.deleteProduct(id);
        return new ResponseEntity(new StandardResponse(200, "Done", done), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductDto dto) {
        if (dto.getId()<= 0) {
            throw new NotFoundException("No id provided to update");

        }
       productService.updateProduct(dto);
        return new ResponseEntity(new StandardResponse(200, "Done", dto), HttpStatus.OK);
    }
    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/total")
    public int getTotalUsers() {
        return productRepo.getTotalProducts();
    }
    }
