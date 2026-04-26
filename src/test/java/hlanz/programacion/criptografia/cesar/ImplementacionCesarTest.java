package hlanz.programacion.criptografia.cesar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementacionCesarTest {

    @Test
    public void test() {
        // Letras
        assertEquals('B',ImplementacionCesar.getLetraDesplazada('A',1));
        assertEquals('K',ImplementacionCesar.getLetraDesplazada('H',3));
        assertEquals('A',ImplementacionCesar.getLetraDesplazada('Z',1));
        assertEquals('Z',ImplementacionCesar.getLetraDesplazada('A',-1));
        assertEquals('H',ImplementacionCesar.getLetraDesplazada('K',-3));
        assertEquals('D',ImplementacionCesar.getLetraDesplazada('V',8));
        assertEquals('T',ImplementacionCesar.getLetraDesplazada('B',-8));

        // Palabras
        assertEquals("KROD",ImplementacionCesar.desplazarPalabra("HOLA",3));
        assertEquals("HOLA",ImplementacionCesar.desplazarPalabra("KROD",-3));
        assertEquals("IPMB",ImplementacionCesar.desplazarPalabra("HOLA",1));
        assertEquals("HOLA",ImplementacionCesar.desplazarPalabra("IPMB",-1));
        assertEquals("BCRCVQ",ImplementacionCesar.desplazarPalabra("ZAPATO",2));
        assertEquals("ZAPATO",ImplementacionCesar.desplazarPalabra("BCRCVQ",-2));


    }
}