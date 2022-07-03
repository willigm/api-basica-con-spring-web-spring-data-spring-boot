package com.jdreyes.bussines;

import com.jdreyes.modelo.Product;
import com.jdreyes.modelo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final List<Product> products = new ArrayList<>();

    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        products.add(product);
        System.out.println("Guardado");
    }

    public void show(){
        String message = products.stream().map(p -> String.format("%d - %s\n", p.getId(), p.getName())).collect(Collectors.joining(""));
        System.out.printf(message);
    }
    public Optional<Product> buscarbyid(int id){
      return  productRepository.findById(id);
    }

    public List<Product> getProducts(){return productRepository.findAll();}




}
