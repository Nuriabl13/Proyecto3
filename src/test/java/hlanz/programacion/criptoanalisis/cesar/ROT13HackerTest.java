package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.HackExito;
import hlanz.programacion.criptoanalisis.HackFracaso;
import hlanz.programacion.criptoanalisis.HackResult;
import org.junit.Test;

import static org.junit.Assert.*;

public class ROT13HackerTest {
    @Test
    public void test1(){
        CesarHacker c=new ROT13Hacker(75);
        HackResult h=c.descifrar("UBL RF HA YHARF");
        assertTrue(h instanceof HackExito);
        if(h instanceof HackExito he){
            assertEquals("HOY ES UN LUNES",he.textoDescifrado());
            assertEquals("Español",he.idioma().getNombre());
        }
    }

    @Test
    public void test2(){
        CesarHacker c=new ROT13Hacker(75);
        HackResult h=c.descifrar("UBL RF AVTUG YHARF");
        assertTrue(h instanceof HackExito);
        if(h instanceof HackExito he){
            assertEquals("HOY ES NIGHT LUNES",he.textoDescifrado());
            assertEquals("Español",he.idioma().getNombre());
        }
    }

    @Test
    public void test3(){
        CesarHacker c=new ROT13Hacker(90);
        HackResult h=c.descifrar("UBL RF AVTUG YHARF");
        assertTrue(h instanceof HackFracaso);
        if(h instanceof HackFracaso hf){
            assertEquals("idioma desconocido",hf.motivo());
        }
    }

    @Test
    public void test4(){
        CesarHacker c=new ROT13Hacker(50);
        HackResult h=c.descifrar("YRNEA WNIN SBE TERNG TBBQ");
        assertTrue(h instanceof HackExito);
        if(h instanceof HackExito he){
            assertEquals("LEARN JAVA FOR GREAT GOOD",he.textoDescifrado());
            assertEquals("Inglés",he.idioma().getNombre());
        }
    }
}