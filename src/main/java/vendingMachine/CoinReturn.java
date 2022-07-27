package vendingMachine;

import coins.Coin;

import java.util.ArrayList;

public class CoinReturn {

    private ArrayList<Coin>returned;

    public CoinReturn() {
        this.returned = new ArrayList<>();
    }


    public int getReturnedValue() {
        int total = 0;
        for(Coin coin : returned){
            total += coin.getCoinType().getValue();
        }return total;
    }

    public void addToReturned(Coin coin) {
        this.returned.add(coin);
    }

    public int returnedSize(){
        return returned.size();
    }

    public void clear(){
        returned.clear();
    }

    public void setReturned(ArrayList<Coin> returned) {
        this.returned = returned;
    }
}
