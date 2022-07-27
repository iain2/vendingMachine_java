package vendingMachine;

import products.Product;

public class Drawer {

    private Product product;
    private CodeType code;

    public Drawer(Product product, CodeType code) {
        this.product = product;
        this.code = code;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
