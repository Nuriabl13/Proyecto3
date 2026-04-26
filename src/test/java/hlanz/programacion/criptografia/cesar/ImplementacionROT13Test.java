package hlanz.programacion.criptografia.cesar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImplementacionROT13Test {
 @Test
    public void test(){
     ROT13Factory r = new ROT13Factory();

     assertEquals("UBYN",r.getCifrador().cifrar("HOLA","3"));
     assertEquals("HOLA",r.getCifrador().cifrar("UBYN","-3"));

     assertEquals("UBYN",r.getCifrador().cifrar("HOLA","1"));
     assertEquals("HOLA",r.getCifrador().cifrar("UBYN","-1"));

     assertEquals("MNCNGB",r.getCifrador().cifrar("ZAPATO","2"));
     assertEquals("ZAPATO",r.getCifrador().cifrar("MNCNGB","-2"));

     assertEquals("MNCNGB",r.getCifrador().cifrar("ZAPATO","6"));
     assertEquals("ZAPATO",r.getCifrador().cifrar("MNCNGB","-6"));

 }
}