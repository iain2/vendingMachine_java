package productTests;

import org.junit.Before;
import org.junit.Test;
import products.Cola;

import static org.junit.Assert.assertEquals;


public class ProductTest {


    Cola cola;


    @Before
    public void before(){
        cola = new Cola("cola", "Pepsi", 75);
    }


    @Test
    public void hasName(){
        assertEquals("cola", cola.getName());

    }

    @Test
    public void hasBrand(){
        assertEquals("Pepsi", cola.getBrand());
    }

    @Test
    public void hasPrice(){
        assertEquals(75, cola.getPrice());
    }

}
