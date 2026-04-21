package hlanz.programacion.criptoanalisis;

import java.io.IOException;
import java.util.Set;

public class Idioma {
    private String nombre;
    private Set<String> palabras;

    public Idioma(String nombre, String ruta) throws IOException{

    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean contienePalabra(String p){
        return false;
    }

    public boolean contieneFrase(String frase, int porcentajeTolerancia){
        return false;
    }
}
