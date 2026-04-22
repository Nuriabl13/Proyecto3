package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.*;
import hlanz.programacion.criptografia.cesar.CesarFactory;
import hlanz.programacion.criptografia.cesar.ImplementacionCesar;
import hlanz.programacion.criptografia.general.AlgoritmoCifrado;
import hlanz.programacion.criptografia.general.CriptografiaAbstractFactory;
import hlanz.programacion.criptografia.general.CriptografiaFactory;
import hlanz.programacion.criptografia.general.Descifrador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CesarHacker implements Hackeador {
    protected List<Idioma> idiomasPosibles;
    protected int porcentajeTolerancia;

    CesarHacker(int porcentajeTolerancia){
        this.porcentajeTolerancia=porcentajeTolerancia;
        this.idiomasPosibles=new ArrayList<>();
        try {
            this.idiomasPosibles.add(new Idioma("Español","src/recursos/spanish.txt"));
            this.idiomasPosibles.add(new Idioma("Inglés","src/recursos/english.txt"));
        } catch (IOException e) {
            System.out.println("ERROR: Idioma no encontrado: "+e.getMessage());
        }
    }

    @Override
    public HackResult descifrar(String texto) {
        CriptografiaFactory cf=CriptografiaAbstractFactory.getFactory(AlgoritmoCifrado.CESAR);
        Descifrador d=cf.getDescifrador();
        String mensaje="";
        boolean funciona=false;
        Idioma idiomaTexto=null;
        String clave="";
        for(int i=0;i<26 && !funciona;i++){
            mensaje=mensaje+d.descifrador(texto,i+"");
            for(Idioma j:this.idiomasPosibles){
                if(j.contieneFrase(mensaje,this.porcentajeTolerancia)){
                    funciona=true;
                    idiomaTexto=j;
                    clave=i+"";
                }
            }
        }
        HackResult hr=null;
        if (funciona){
            hr=new HackExito(texto,mensaje,clave,idiomaTexto);
        }else{
            hr=new HackFracaso("Idioma desconocido");
        }
        return hr;
    }
}
