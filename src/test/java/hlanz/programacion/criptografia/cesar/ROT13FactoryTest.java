package hlanz.programacion.criptografia.cesar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ROT13FactoryTest {
    @Test
    public void test1(){
        ROT13Factory i = new ROT13Factory();
        assertTrue( i.getCifrador() instanceof ImplementacionROT13);
    }
    @Test
    public void test2(){
        ROT13Factory i = new ROT13Factory();
        assertTrue( i.getDescifrador() instanceof ImplementacionROT13);
    }
}