package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.Hackeador;
import hlanz.programacion.criptografia.general.AlgoritmoCifrado;
import org.junit.Test;

import static org.junit.Assert.*;

public class HackeadorFactoryTest {
    @Test
    public void test1(){
        Hackeador h=HackeadorFactory.getHackeador(AlgoritmoCifrado.CESAR,74);
        assertNotNull(h);
        assertTrue(h instanceof CesarHacker);
        assertEquals(74,((CesarHacker) h).porcentajeTolerancia);
    }

    @Test
    public void test2(){
        Hackeador h=HackeadorFactory.getHackeador(AlgoritmoCifrado.ROT13,74);
        assertNotNull(h);
        assertTrue(h instanceof ROT13Hacker);
        assertEquals(93,((ROT13Hacker) h).porcentajeTolerancia);
    }

    @Test
    public void test3() throws IllegalArgumentException{
        Hackeador h=HackeadorFactory.getHackeador(AlgoritmoCifrado.CESAR,-52);
    }
}
