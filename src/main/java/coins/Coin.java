package coins;

public class Coin {

    CoinType coinType;

    public Coin(CoinType coinType){
        this.coinType = coinType;
    }

    public CoinType getCoinType() {
        return coinType;
    }

    public int getCoinValue(){
        return coinType.getValue();
    }


}
