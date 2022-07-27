package vendingMachineTests;

import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;
import vendingMachine.CoinReturn;

import static org.junit.Assert.assertEquals;

public class CoinReturnTest {

    CoinReturn coinReturn;
    Coin coin;
    Coin coin50;
    Coin coin20;
    Coin coin10;
    Coin coin5;
    Coin coin2;
    Coin coin1;

    @Before
    public void before(){
        coinReturn = new CoinReturn();
        coin = new Coin(CoinType.ONEPOUND);
        coin50 = new Coin(CoinType.FIFTYPENCE);
        coin20 = new Coin(CoinType.TWENTYPENCE);
        coin10 = new Coin(CoinType.TENPENCE);
        coin5 = new Coin(CoinType.FIVEPENCE);
        coin2 = new Coin(CoinType.TWOPENCE);
        coin1 = new Coin(CoinType.ONEPENCE);

    }


    @Test
    public void canAddCoin(){
        coinReturn.addToReturned(coin);
        assertEquals(1, coinReturn.returnedSize());
    }

    @Test
    public void canGetValue(){
        coinReturn.addToReturned(coin);
        coinReturn.addToReturned(coin50);
        assertEquals(150, coinReturn.getReturnedValue());
    }

    @Test
    public void canClear(){
        coinReturn.addToReturned(coin);
        coinReturn.addToReturned(coin50);
        coinReturn.addToReturned(coin20);
        coinReturn.clear();
        assertEquals(0, coinReturn.returnedSize());
    }

}
