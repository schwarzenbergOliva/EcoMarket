package Repository;

import Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> listaProducts = new ArrayList<>();

    public List<Product> oftenerProducts() {
        return listaProducts;
    }

    public Product buscarProductoID(int id) {
        for (Product product : listaProducts) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product guardar(Product pro) {
        listaProducts.add(pro);
        return pro;

    }

    public Product actualizar(Product pro) {
        int idPosicion = -1;

        for (int i = 0; i < listaProducts.size(); i++) {
            if (listaProducts.get(i).getId() == pro.getId()) {
                idPosicion = i;
                break;
            }
        }

        if (idPosicion != -1) {
            Product productActualizado = new Product();
            productActualizado.setId(pro.getId());
            productActualizado.setNombre(pro.getNombre());
            productActualizado.setPrecio(pro.getPrecio());
            productActualizado.setStock(pro.getStock());

            listaProducts.set(idPosicion, productActualizado);
            return productActualizado;
        }

        return null;
    }

    public void eliminar(int id) {
        Product product = buscarProductoID(id);
        if (product != null) {
            listaProducts.remove(product);
        }
    }
}


