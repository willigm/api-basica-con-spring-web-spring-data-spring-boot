package com.jdreyes;

import com.jdreyes.bussines.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    InventoryService service;

    public static void main(String[] args) {
                SpringApplication.run(App.class, args);
//        AnnotationConfigApplicati``onContext context = new AnnotationConfigApplicationContext();
//        context.scan("com.jdreyes");
//        context.refresh();``
//


    }

    @Override
    public void run(String... args) throws Exception {
        //        Product p1 = new Product(1, "LECHE");
//        Product p2 = new Product(3, "FRIJOLES");
//        Product p3 = new Product(4, "QUESO");
//        Product p4 = new Product(5, "AGUA");
//

//        service.addProduct(p1);
//        service.inputOf(p1, 10);
//        service.inputOf(p2, 20);
//        service.inputOf(p3, 30);
//        service.inputOf(p4, 40);
//        service.MostrarInventario(6);
//        service.mostrarStock();
          service.MostrarInventario(10);
//        service.requesProvicer(p1);
    }
}
