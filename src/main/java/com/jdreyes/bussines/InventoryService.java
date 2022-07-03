package com.jdreyes.bussines;

import com.jdreyes.config.LanguageConfig;
import com.jdreyes.modelo.Product;
import com.jdreyes.modelo.StockRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InventoryService {

  private final ProductService productService;
  private  final StockRepository stockRepository;

  private final BeanFactory factory;

  private static Map<Product, Integer> products = new HashMap<>();

  @Autowired
  public InventoryService(ProductService productService, StockRepository stockRepository, BeanFactory factory) {
    this.productService = productService;
    this.stockRepository = stockRepository;
    this.factory = factory;
  }

  public void inputOf(Product product, Integer q) {
    products.computeIfPresent(product, (k1, v1) -> v1.intValue() + q);
    if (!products.containsKey(product.getId())) {
      productService.save(product);
      products.put(product, q);
    }
  }

  public void outOf(Product product, Integer q) {
    products.computeIfPresent(product, (k1, v1) -> v1.intValue() - q);
  }

  public void addProduct(Product product) {
    if (productService.getProducts().stream().noneMatch(p -> p.getId() == product.getId())) {
      productService.save(product);
      products.put(product, 0);
    } else {
      System.out.println("Este producto ya se encuenta registrado!");
    }
  }

  public void requesProvicer(Product p) {

    LanguageConfig langua = factory.getBean(LanguageConfig.class);
    System.out.println("Verificando su pedido");
  }

  public void MostrarInventario(int id) {
    stockRepository.findById(id).ifPresent(z-> {
      System.out.println(
              "El producto es : "
                      + z.getProduct().getName()
                      + " la cantidad en Stock es de : "
                      + z.getCantidad());
    });
  }

  public void mostrarStock(){

  String message=  productService.getProducts().stream().map(this::formatProduct).collect(Collectors.joining(""));
    System.out.println(message);
  }

  private String formatProduct(Product p){
      return String.format(" Producto :%s Stock %d \n", p.getName(),products.get(p) == null ? 0 : products.get(p));
  }
}
