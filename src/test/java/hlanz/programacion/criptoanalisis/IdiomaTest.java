package hlanz.programacion.criptoanalisis;


import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class IdiomaTest {
    @Test
    public void test1(){
        try {
            Idioma idioma = new Idioma("Español",
                    "spanish.txt");
            assertNotNull(idioma);
            assertTrue(idioma.contienePalabra("HOLA"));
            assertFalse(idioma.contienePalabra("noche"));
            assertTrue(idioma.contienePalabra("TIGRE"));
            assertFalse(idioma.contienePalabra("NIGHT"));
            assertTrue(idioma.contienePalabra("DRAGON"));
            assertFalse(idioma.contienePalabra("XZCTBGJ3"));
            assertTrue(idioma.contieneFrase("HOY ES UN LUNES",80));
            assertTrue(idioma.contieneFrase("HOY ES UN NIGHT",75));
            assertFalse(idioma.contieneFrase("HOY ES UN NIGHT",80));
            assertFalse(idioma.contieneFrase("ASD XCV XTEXZ",10));
        } catch (IOException e) {
            System.out.println(e.getMessage()
            );
        }
    }

    @Test
    public void test2(){
        try {
            Idioma idioma = new Idioma("Inglés","english.txt");
            assertNotNull(idioma);
            assertTrue(idioma.contienePalabra("BROTHER"));
            assertFalse(idioma.contienePalabra("brother"));
            assertTrue(idioma.contienePalabra("TIGER"));
            assertFalse(idioma.contienePalabra("NOCHE"));
            assertTrue(idioma.contienePalabra("DRAGON"));
            assertFalse(idioma.contienePalabra("XZCTBGJ3"));
            assertTrue(idioma.contieneFrase("THERE IS A CAT",80));
            assertTrue(idioma.contieneFrase("THERE IS A XZCTBGJ3",75));
            assertFalse(idioma.contieneFrase("THERE IS A XZCTBGJ3",80));
            assertFalse(idioma.contieneFrase("ASD XCV XTEXZ",10));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}