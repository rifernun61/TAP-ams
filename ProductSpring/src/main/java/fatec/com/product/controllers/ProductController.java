package fatec.com.product.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.com.product.models.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

        @GetMapping
        public ArrayList<Product> getProducts() {

            //Declara um variavel do tipo Product
            //Cria um objeto do tipo Product e atribui a variavel
            Product p1 = new Product();
            p1.setId(1L);
            p1.setName("Notebook");
            p1.setPrice(3500.00);
            p1.setDescription("Notebook i7 512 16gb");
            
            Product p2 = new Product();
            p2.setId(2L);
            p2.setName("Smartphone");
            p2.setPrice(2000.00);
            p2.setDescription("Smartphone android 128gb");
            Product p3 = new Product();
            p3.setId(3L);
            p3.setName("Tablet");
            p3.setPrice(1500.00);
            p3.setDescription("Tablet android 64gb");

            ArrayList<Product> products = new ArrayList<>();
            products.add(p1);
            products.add(p2);   
            products.add(p3);

            return products;
        }

}
