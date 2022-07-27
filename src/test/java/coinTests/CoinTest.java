package coinTests;

import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin coin;

    @Before
    public void before(){
        coin = new Coin(CoinType.ONEPOUND);
    }

    @Test
    public void coinHasValue(){
        assertEquals(100, coin.getCoinValue());
    }

    @Test
    public void coinHasCoinType(){
        assertEquals(CoinType.ONEPOUND, coin.getCoinType());
    }


}
