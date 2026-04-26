package hlanz.programacion.criptografia.cesar;

import org.junit.Test;

import static org.junit.Assert.*;

public class CesarFactoryTest {
    @Test
    public void test1(){
        CesarFactory c = new CesarFactory();
        assertTrue( c.getCifrador() instanceof ImplementacionCesar);
    }
    @Test
    public void test2(){
        CesarFactory c = new CesarFactory();
        assertTrue( c.getDescifrador() instanceof ImplementacionCesar);
    }
}