package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.HackExito;
import hlanz.programacion.criptoanalisis.HackResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class CesarHackerTest {
    @Test
    public void test1(){
        CesarHacker c=new CesarHacker(75);
        HackResult h=c.descifrar("KRB HV XQ OXQHV");
        assertTrue(h instanceof HackExito);
        if(h instanceof HackExito he){
            assertEquals("HOY ES UN LUNES",he.textoDescifrado());
            assertEquals("Español",he.idioma().getNombre());
        }
    }

    @Test
    public void test2(){
        CesarHacker c=new CesarHacker(75);
        HackResult h=c.descifrar("TAK QE ZUSTF XGZQE");
        assertTrue(h instanceof HackExito);
        if(h instanceof HackExito he){
            assertEquals("HOY ES NIGHT LUNES",he.textoDescifrado());
            assertEquals("Español",he.idioma().getNombre());
        }
    }
}