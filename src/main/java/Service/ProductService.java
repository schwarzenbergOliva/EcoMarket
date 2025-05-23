package Service;

import Model.Product;
import Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.oftenerProducts();
    }

    public Product saveProduct(Product product) {
        return productRepository.guardar(product);
    }

    public Product getProductID(int id) {
        return productRepository.buscarProductoID(id);
    }

    public Product updateProduct(Product product) {
        return productRepository.actualizar(product);
    }

    public String deleteProduct(int id) {
        productRepository.eliminar(id);
        return "Producto eliminado";
    }
}

