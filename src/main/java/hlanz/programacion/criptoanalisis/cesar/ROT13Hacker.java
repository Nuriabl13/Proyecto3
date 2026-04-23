package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.HackExito;
import hlanz.programacion.criptoanalisis.HackFracaso;
import hlanz.programacion.criptoanalisis.HackResult;
import hlanz.programacion.criptoanalisis.Idioma;
import hlanz.programacion.criptografia.general.AlgoritmoCifrado;
import hlanz.programacion.criptografia.general.CriptografiaAbstractFactory;
import hlanz.programacion.criptografia.general.CriptografiaFactory;
import hlanz.programacion.criptografia.general.Descifrador;

public class ROT13Hacker extends CesarHacker {
    ROT13Hacker(int nivelTolerancia){
        super(nivelTolerancia);
    }

    @Override
    public HackResult descifrar(String texto){
        CriptografiaFactory cf= CriptografiaAbstractFactory.getFactory(AlgoritmoCifrado.ROT13);
        Descifrador d=cf.getDescifrador();
        String res=d.descifrador(texto,""+13);
        boolean funciona=false;
        Idioma idiomaTexto=null;
        for(Idioma j:this.idiomasPosibles){
            if(j.contieneFrase(res,this.porcentajeTolerancia)){
                funciona=true;
                idiomaTexto=j;
            }
        }
        HackResult hr=null;
        if (funciona){
            hr=new HackExito(texto,res,"13",idiomaTexto);
        }else{
            hr=new HackFracaso("Idioma desconocido");
        }
        return hr;
    }
}
