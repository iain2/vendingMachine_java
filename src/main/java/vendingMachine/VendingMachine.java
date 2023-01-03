package vendingMachine;

import coins.Coin;
import coins.CoinType;
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

    public ArrayList<Drawer> getDrawers() {
        return drawers;
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

    public int getChangeValue(Product product) {
        return this.getTillValue() - product.getPrice();
    }

    public void returnChange(int change) {
        ArrayList<Integer> numberList = new ArrayList<>();
        ArrayList<Coin> changeList = new ArrayList<>();
        ArrayList<Coin> coins = new ArrayList<>();
        coins.add(new Coin(CoinType.ONEPOUND));
        coins.add(new Coin(CoinType.FIFTYPENCE));
        coins.add(new Coin(CoinType.TWENTYPENCE));
        coins.add(new Coin(CoinType.TENPENCE));
        coins.add(new Coin(CoinType.FIVEPENCE));
        coins.add(new Coin(CoinType.TWOPENCE));
        coins.add(new Coin(CoinType.ONEPENCE));

        int r = change;
        for(int i = 0; r > 0; i++) {
            int c = r / coins.get(i).getCoinValue();
            r = change % coins.get(i).getCoinValue();
            numberList.add(c);
        }
        for(int i = 0; i < numberList.size(); i ++){
            int counter = 0;
            while (counter < numberList.get(i)){
                counter += 1;
                Coin coin = coins.get(i);
                changeList.add(coin);
            }
        }
        coinReturn.setReturned(changeList);
    }

    public Product purchase(Drawer drawer) {
        Product product = drawer.getProduct();
        if (checkBalance(product) != true){
            return null;
        }
        int change = getChangeValue(product);
        returnChange(change);
        this.till = new ArrayList<>();
        return product;
    }

    public ArrayList getReturnedChange(){
        return this.coinReturn.getReturned();
    }
}
