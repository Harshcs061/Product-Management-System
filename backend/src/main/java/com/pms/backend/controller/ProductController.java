
package com.pms.backend.controller;

import com.pms.backend.model.Product;
import com.pms.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping("/saveproduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        System.out.println("Save product fired");
        return new ResponseEntity(productService.saveProduct(product),HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    public ResponseEntity<?> getAllProducts(){
        
        return new ResponseEntity(productService.getAllProducts(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id){
        
        return new ResponseEntity(productService.getProductById(id),HttpStatus.OK);
    }
    
    @GetMapping("/deleteproduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        
        return new ResponseEntity(productService.deleteProduct(id),HttpStatus.OK);
    }
    
    @PostMapping("/editproduct/{id}")
    public ResponseEntity<?> editProduct(@RequestBody Product product, @PathVariable Integer id){
        
        return new ResponseEntity(productService.editProduct(product,id),HttpStatus.CREATED);
    }
    
    
}
