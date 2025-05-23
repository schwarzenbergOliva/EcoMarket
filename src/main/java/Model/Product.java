package Model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter // Modelo
public class Product {


    private int id;
    private String nombre;
    private int precio;
    private int stock;

    public Product() {
    }

    public Product(int id, String nombre, int precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

}


