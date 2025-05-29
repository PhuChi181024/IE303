import java.io.Serializable;

public class Product implements Serializable {
    String name;
    String image;
    String price;
    String brand;
    String description;

    Product(String name, String image, String price, String brand, String description) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.brand = brand;
        this.description = description;
    }
}