package fatec.com.product.controllers;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fatec.com.product.models.Product;
import fatec.com.product.models.SpecialProduct;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Listas em memória — compartilhadas de forma estática para que
    // SpecialProductController acesse os mesmos dados.
    static final ArrayList<Product> products = new ArrayList<>();
    static final ArrayList<SpecialProduct> specialProducts = new ArrayList<>();

    static {
        products.add(new Product(1L, "Notebook",    3500.00, "Notebook i7 512 16gb"));
        products.add(new Product(2L, "Smartphone",  2000.00, "Smartphone android 128gb"));
        products.add(new Product(3L, "Tablet",      1500.00, "Tablet android 64gb"));

        specialProducts.add(new SpecialProduct(4L, "Notebook Pro", 5000.00,
                "Notebook gamer high-end", "XG17", "ASUS"));
    }

    // ─── Product CRUD ────────────────────────────────────────────────────────

    /** GET /products → lista todos os produtos comuns */
    @GetMapping
    public ArrayList<Product> getProducts() {
        return products;
    }

    /** GET /products/{id} → busca produto comum por id */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** POST /products → cadastra novo produto comum */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        products.add(product);
        return ResponseEntity.status(201).body(product);
    }

    /** PUT /products/{id} → altera produto comum existente */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,
                                                  @RequestBody Product updated) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                updated.setId(id);
                products.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /** DELETE /products/{id} → remove produto comum */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        boolean removed = products.removeIf(p -> p.getId() == id);
        return removed ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }

    // ─── SpecialProduct CRUD (via ProductController) ────────────────────────

    /** GET /products/special → lista todos os produtos especiais */
    @GetMapping("/special")
    public ArrayList<SpecialProduct> getSpecialProducts() {
        return specialProducts;
    }

    /** GET /products/special/{id} → busca produto especial por id */
    @GetMapping("/special/{id}")
    public ResponseEntity<SpecialProduct> getSpecialProductById(@PathVariable long id) {
        return specialProducts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** POST /products/special → cadastra novo produto especial */
    @PostMapping("/special")
    public ResponseEntity<SpecialProduct> createSpecialProduct(@RequestBody SpecialProduct product) {
        specialProducts.add(product);
        return ResponseEntity.status(201).body(product);
    }

    /** PUT /products/special/{id} → altera produto especial existente */
    @PutMapping("/special/{id}")
    public ResponseEntity<SpecialProduct> updateSpecialProduct(@PathVariable long id,
                                                                @RequestBody SpecialProduct updated) {
        for (int i = 0; i < specialProducts.size(); i++) {
            if (specialProducts.get(i).getId() == id) {
                updated.setId(id);
                specialProducts.set(i, updated);
                return ResponseEntity.ok(updated);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /** DELETE /products/special/{id} → remove produto especial */
    @DeleteMapping("/special/{id}")
    public ResponseEntity<Void> deleteSpecialProduct(@PathVariable long id) {
        boolean removed = specialProducts.removeIf(p -> p.getId() == id);
        return removed ? ResponseEntity.noContent().build()
                       : ResponseEntity.notFound().build();
    }
}

