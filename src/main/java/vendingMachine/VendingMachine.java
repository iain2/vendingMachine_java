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
        int pounds = change / 100;
        int r = change % 100;
        int fiftyPence = r / 50;
        int r2 = r % 50;
        int twentyPence = r2 / 20;
        int r3 = r2 % 20;
        int tenPence = r3 / 10;
        int r4 = r3 % 10;
        int fivePence = r4 / 5;
        int r5 = r4 % 5;
        int twoPence = r5 / 2;
        int onePence = r5 % 2;


        int counter = 0;
        while (counter < pounds){
            counter += 1;
            Coin coin = new Coin(CoinType.ONEPOUND);
            changeList.add(coin);
        }
        counter = 0;
        while (counter < fiftyPence){
            counter += 1;
            Coin coin = new Coin(CoinType.FIFTYPENCE);
            changeList.add(coin);
        }
        counter = 0;
        while (counter < twentyPence){
            counter += 1;
            Coin coin = new Coin(CoinType.TWENTYPENCE);
            changeList.add(coin);
        }
        counter = 0;
        while (counter < tenPence){
            counter += 1;
            Coin coin = new Coin(CoinType.TENPENCE);
            changeList.add(coin);
        }
        counter = 0;
        while (counter < fivePence){
            counter += 1;
            Coin coin = new Coin(CoinType.FIVEPENCE);
            changeList.add(coin);
        }
        counter = 0;
        while (counter < twoPence){
            counter += 1;
            Coin coin = new Coin(CoinType.TWOPENCE);
            changeList.add(coin);
        }
        counter = 0;
        while (counter < onePence){
            counter += 1;
            Coin coin = new Coin(CoinType.ONEPENCE);
            changeList.add(coin);
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
