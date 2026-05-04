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

import fatec.com.product.models.SpecialProduct;

/**
 * Controller dedicado ao recurso SpecialProduct.
 *
 * Base path: /special-products
 *
 * Reutiliza a lista estática de ProductController para que ambos os
 * controllers trabalhem sobre o mesmo conjunto de dados em memória.
 */
@RestController
@RequestMapping("/special-products")
public class SpecialProductController {

    // Referência à lista estática mantida em ProductController
    private final ArrayList<SpecialProduct> specialProducts = ProductController.specialProducts;

    // ─── GET ─────────────────────────────────────────────────────────────────

    /** GET /special-products → retorna todos os produtos especiais */
    @GetMapping
    public ArrayList<SpecialProduct> getAll() {
        return specialProducts;
    }

    /** GET /special-products/{id} → retorna produto especial por id */
    @GetMapping("/{id}")
    public ResponseEntity<SpecialProduct> getById(@PathVariable long id) {
        return specialProducts.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ─── POST ────────────────────────────────────────────────────────────────

    /**
     * POST /special-products → cadastra novo produto especial
     *
     * Body JSON esperado:
     * {
     *   "id": 5,
     *   "name": "Smartwatch",
     *   "price": 1200.00,
     *   "description": "Relógio inteligente",
     *   "model": "Series X",
     *   "brand": "Apple"
     * }
     */
    @PostMapping
    public ResponseEntity<SpecialProduct> create(@RequestBody SpecialProduct product) {
        specialProducts.add(product);
        return ResponseEntity.status(201).body(product);
    }

    // ─── PUT ─────────────────────────────────────────────────────────────────

    /**
     * PUT /special-products/{id} → atualiza produto especial existente.
     * Todos os campos são substituídos pelo corpo da requisição.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SpecialProduct> update(@PathVariable long id,
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

    // ─── DELETE ──────────────────────────────────────────────────────────────

    /** DELETE /special-products/{id} → remove produto especial */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean removed = specialProducts.removeIf(p -> p.getId() == id);
        return removed
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
