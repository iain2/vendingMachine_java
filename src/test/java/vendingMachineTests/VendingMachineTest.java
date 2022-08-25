package vendingMachineTests;

import coins.Coin;
import coins.CoinType;
import org.junit.Before;
import org.junit.Test;
import products.Cola;
import products.Crisps;
import products.Product;
import products.Sweets;
import vendingMachine.CodeType;
import vendingMachine.CoinReturn;
import vendingMachine.Drawer;
import vendingMachine.VendingMachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class VendingMachineTest {

    VendingMachine vendingMachine;

    CoinReturn coinReturn;
    Coin coin;
    Coin coin50;
    Coin coin20;
    Coin coin10;
    Coin coin5;
    Coin coin2;
    Coin coin1;

    Drawer drawer1;
    Drawer drawer2;
    Drawer drawer3;

    Crisps crisps;
    Cola cola;
    Sweets sweets;

    @Before
    public void before(){
        vendingMachine = new VendingMachine();
        sweets = new Sweets("Gummy Drops", "Haribo",90);
        cola = new Cola("Lemonade", "Sprite", 80);
        crisps = new Crisps("Cheese & Onion", "Walkers", 65);
        drawer1 = new Drawer(crisps, CodeType.A1);
        drawer2 = new Drawer(cola, CodeType.A2);
        drawer3 = new Drawer(sweets,CodeType.A3);
        coin = new Coin(CoinType.ONEPOUND);
        coin50 = new Coin(CoinType.FIFTYPENCE);
        coin20 = new Coin(CoinType.TWENTYPENCE);
        coin10 = new Coin(CoinType.TENPENCE);
        coin5 = new Coin(CoinType.FIVEPENCE);
        coin2 = new Coin(CoinType.TWOPENCE);
        coin1 = new Coin(CoinType.ONEPENCE);
        vendingMachine.addDrawer(drawer1);
        vendingMachine.addDrawer(drawer2);
        vendingMachine.addDrawer(drawer3);

    }

    @Test
    public void canAddCoin(){
        vendingMachine.addCoin(coin10);
        assertEquals(1, vendingMachine.getTillSize());
    }

    @Test
    public void canTillValue(){
        vendingMachine.addCoin(coin);
        vendingMachine.addCoin(coin50);
        assertEquals(150, vendingMachine.getTillValue());
    }

    @Test
    public void canCheckCoinReturn(){
        assertEquals(0, vendingMachine.getCoinReturnSize());
    }

    @Test
    public void checkCoin(){
        vendingMachine.addCoin(coin1);
        assertEquals(0, vendingMachine.getTillSize());
        assertEquals(1, vendingMachine.getCoinReturnSize());
    }

    @Test
    public void canAddDrawer(){

        assertEquals(3, vendingMachine.getDrawersSize());
    }

    @Test
    public void canGetDrawer(){

        assertEquals(drawer3, vendingMachine.selectDrawer(CodeType.A3));
    }

    @Test
    public void canGetProduct(){
        assertEquals(crisps, vendingMachine.getProduct(drawer2));
    }

    @Test
    public void canGetProductPrice(){
        assertEquals(65, vendingMachine.getProductPrice(crisps));
    }

    @Test
    public void canCheckPrice(){

        assertEquals(false, vendingMachine.checkBalance(crisps));
    }

    @Test
    public void canCheckPriceTrue(){
        vendingMachine.addCoin(coin);
        assertEquals(true, vendingMachine.checkBalance(crisps));
    }

    @Test
    public void canUpdateTill(){
        vendingMachine.addCoin(coin);
        vendingMachine.addCoin(coin50);
        assertEquals(70, vendingMachine.getChangeValue(cola));
    }

    @Test
    public void canReturnChange(){
        vendingMachine.returnChange(140);
        assertEquals(140, vendingMachine.getCoinReturnValue());
    }

    @Test
    public void canPurchaseItem(){
        vendingMachine.addCoin(coin);
        Product e = vendingMachine.purchase(drawer1);
        assertEquals(crisps, e);
    }

    @Test
    public void canPurchaseItemInsiffucientFunds(){
        vendingMachine.addCoin(coin20);
        Product e = vendingMachine.purchase(drawer1);
        assertNull( e);
    }








}
