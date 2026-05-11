package fatec.com.product.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private Long id;
    private String name;

    private List<Product> products = new ArrayList<>();

    public Category(){}

    public Category(Long id, String name, List<Product> product) {
        this.id = id;
        this.name = name;
        this.products = product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getId(){
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products.add(product);
    }
    

}
