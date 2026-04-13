package fatec.com.product.models;

public class SpecialProduct extends Product {
    private String model;
    private String brand;

    public SpecialProduct() {
        super();
    }

    public SpecialProduct(Long id, String name, Double price, String description, String model, String brand) {
        super(id, name, price, description);
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
