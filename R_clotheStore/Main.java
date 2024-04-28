import product.*;
import product.Shirt;
import product.Shirt.Size;

public class Main {

    public static void main(String[] args) {
        Shirt shirt = new Shirt(10.99, "Red", "Nike", Size.LARGE);
        shirt.setSize(Size.SMALL);
        shirt.setBrand("ADIDAS");
        shirt.setPrice(49.99);
        shirt.setColor("BLUE");
        shirt.fold();
        productStore(shirt);

        Pants pants = new Pants(499.99, "Black", "Levi's", 32, 32);
        pants.setWaist(32);
        pants.setLength(32);
        pants.setColor("BLACK");
        pants.setBrand("ADIDAS");
        pants.setPrice(99.99);
        pants.fold();
        productStore(pants);
    }

    public static void productStore(Product product){
        System.out.println("Thank you for purchasing " + product.getBrand() + " " + product.getClass().getSimpleName().toLowerCase() + ". Your total comes to " + product.getPrice() + "." );
        product.wear();
    }

}
