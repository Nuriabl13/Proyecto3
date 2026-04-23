package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.Hackeador;
import hlanz.programacion.criptografia.general.AlgoritmoCifrado;

public class HackeadorFactory {
    public static Hackeador getHackeador(AlgoritmoCifrado a, int pcTolerancia){
        if(pcTolerancia<0 || pcTolerancia>100){
            throw new IllegalArgumentException("El porcentaje de tolerancia debe estar entre [0,100]");
        }

        Hackeador h=null;
        if(a.equals(AlgoritmoCifrado.CESAR)){
            h=new CesarHacker(pcTolerancia);
        }else{
            h=new ROT13Hacker(pcTolerancia);
        }

        return h;
    }
}
