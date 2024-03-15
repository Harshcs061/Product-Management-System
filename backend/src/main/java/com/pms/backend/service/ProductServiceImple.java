/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pms.backend.service;

import com.pms.backend.model.Product;
import com.pms.backend.repository.ProductRepository;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service
public class ProductServiceImple implements ProductService{

    @Autowired
    private ProductRepository productRepo;
    
    @Override
    public Product saveProduct(Product product) {
        
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        
        return productRepo.findById(id).get();
    }

    @Override
    public String deleteProduct(Integer id) {
        
        Product product = productRepo.findById(id).get();
        
        if(product != null){
            productRepo.delete(product);
            return "Product deleted Successfully";
        }
        
        return "Something went wrong.";
    }

    @Override
    public Product editProduct(Product product,Integer id) {
        
        try{
            Product myProduct= productRepo.findById(id).get();
            deleteProduct(id);
            return saveProduct(product);
        }catch(NoSuchElementException e){
            return saveProduct(product);
        }
        
    }
    
}
