/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.pms.backend.service;

import com.pms.backend.model.Product;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ProductService {
    
    public Product saveProduct(Product product);
    
    public List<Product> getAllProducts();
    
    public Product getProductById(Integer id);
    
    public String deleteProduct(Integer id);
    
    public Product editProduct(Product product, Integer id);
}
