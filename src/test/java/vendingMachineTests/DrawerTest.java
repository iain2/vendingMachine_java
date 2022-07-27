package vendingMachineTests;
import org.junit.Before;
import org.junit.Test;
import products.Cola;
import products.Sweets;
import vendingMachine.CodeType;
import vendingMachine.Drawer;

import static org.junit.Assert.assertEquals;

public class DrawerTest {

    Cola cola;
    Drawer drawer;

    @Before
    public void before(){
        cola = new Cola("Lemonade", "Sprite", 80);
        drawer = new Drawer(cola, CodeType.A1);
    }

    @Test
    public void hasProduct(){
        assertEquals(cola, drawer.getProduct());
    }

    @Test
    public void setProduct() {
        Sweets sweet = new Sweets("Gumdrop","Haribo",90);
        drawer.setProduct(sweet);
        assertEquals(sweet, drawer.getProduct());
    }

}
