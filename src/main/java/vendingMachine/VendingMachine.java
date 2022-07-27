package vendingMachine;

import coins.Coin;
import products.Crisps;
import products.Product;

import java.util.ArrayList;

public class VendingMachine {

    private ArrayList<Drawer> drawers;
    private CoinReturn coinReturn;
    private ArrayList<Coin> till;

    public VendingMachine() {
        this.coinReturn = new CoinReturn();
        this.till = new ArrayList<>();
        this.drawers = new ArrayList<>();
    }

    public void addCoin(Coin coin) {
        if(coin.getCoinValue() > 2){
            till.add(coin);
        }coinReturn.addToReturned(coin);

    }

    public int getTillSize() {
        return till.size();
    }

    public int getTillValue() {
        int total = 0;
        for(Coin coin : till){
            total += coin.getCoinType().getValue();
        }return total;
    }

    public int getCoinReturnSize() {
        return coinReturn.returnedSize();
    }

    public int getCoinReturnValue() {
        return coinReturn.getReturnedValue();
    }

    public int getDrawersSize() {
        return drawers.size();
    }

    public void addDrawer(Drawer drawer) {
        drawers.add(drawer);
    }


    public Drawer selectDrawer(CodeType code) {
        return drawers.get(code.getValue());
    }

    public Product getProduct(Drawer drawer) {
        return drawer.getProduct();
    }

    public int getProductPrice(Product product) {
        return product.getPrice();
    }

    public boolean checkBalance(Product product) {
        return this.getTillValue() > product.getPrice();
    }
}
