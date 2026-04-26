package hlanz.programacion.criptoanalisis.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnalizadorFraseTest {

    @Test
    public   void  test1(){
        String frase = "HOY ES LUNES";
        AnalizadorFrase a = new AnalizadorFrase(frase);
        assertEquals(3,a.getNumeroPalabras());
        assertEquals(3,a.getPalabras().size());
        assertEquals("HOY",a.getPalabras().get(0));
        assertEquals("ES",a.getPalabras().get(1));
        assertEquals("LUNES",a.getPalabras().get(2));

    }

    @Test
    public   void  test2(){
        String frase = "YO ESTUDIO EN EL INSTITUTO POLITECNICO HERMENEGILDO LANZ";
        AnalizadorFrase a = new AnalizadorFrase(frase);
        String[] esperadas = {"YO", "ESTUDIO", "EN", "EL", "INSTITUTO", "POLITECNICO", "HERMENEGILDO", "LANZ"};
        for(int i=0; i<esperadas.length;i++){
            assertEquals(esperadas[i],a.getPalabras().get(i));
        }


    }


}