package hlanz.programacion.criptoanalisis;

import java.io.*;
import java.util.Set;

public class Idioma {
    private String nombre;
    private Set<String> palabras;

    public Idioma(String nombre, String ruta) throws IOException{
        this.nombre = nombre;
        FileReader f = new FileReader(new File(ruta));
        BufferedReader b = new BufferedReader(f);
        boolean repetir = true;
        while (repetir){
            String linea = b.readLine();
            if (linea == null){
                repetir = false;
                b.close();
            }else {
                this.palabras.add(linea);
            }
        }
    }

    public String getNombre(){
        return this.nombre;
    }

    public boolean contienePalabra(String p){
        boolean resultado = false;
        if (this.palabras.contains(p)){
            resultado = true;
        }
        return resultado;
    }

    public boolean contieneFrase(String frase, int porcentajeTolerancia){
        return false;
    }
}
