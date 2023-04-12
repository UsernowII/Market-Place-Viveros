package com.viveros.marketplace.controller;

import com.viveros.marketplace.models.Product;
import com.viveros.marketplace.service.ProductService;
import com.viveros.marketplace.util.JWTUtil;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> GetProducts(){
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);

    }

    @PostMapping("/product")
    public ResponseEntity<String> createProduct(
            @RequestBody Product product,
            @RequestHeader(value="Authorization") String token){

        try {
            jwtUtil.getValue(token);
            productService.create(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (SignatureException se){
            return new ResponseEntity<>("Token invalido" , HttpStatus.UNAUTHORIZED);
        }catch (Exception ex) {
            return new ResponseEntity<>("Oops Algo Salio Mal" , HttpStatus.INTERNAL_SERVER_ERROR);
        }





    }

}
