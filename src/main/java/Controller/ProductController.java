package Controller;

import Model.Product;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> listarrProducts() {
        return productService.getProducts();
    }

    @PostMapping
    public Product aggregateProduct(@RequestBody Product product) {
        return productService.saveProduct(product);  // ← corregido aquí
    }

    @GetMapping("{id}")
    public Product buscarProduct(@PathVariable int id) {
        return productService.getProductID(id);
    }

    @PutMapping("{id}")
    public Product actualizarProduct(@PathVariable int id, @RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("{id}")
    public String eliminateProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}


