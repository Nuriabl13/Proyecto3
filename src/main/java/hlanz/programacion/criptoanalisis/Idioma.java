package hlanz.programacion.criptoanalisis;

import hlanz.programacion.criptoanalisis.util.AnalizadorFrase;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Idioma {
    private String nombre;
    private Set<String> palabras;

    public Idioma(String nombre, String ruta) throws IOException{
        this.nombre = nombre;
        this.palabras = new HashSet<>();
        FileReader f = new FileReader(ruta);
        BufferedReader b = new BufferedReader(f);
        boolean repetir = true;
        while (repetir){
            String linea = b.readLine();
            if (linea == null){
                repetir = false;
                b.close();
            }else {
                this.palabras.add(linea.toUpperCase());
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
        boolean resultado = false;
        if (porcentajeTolerancia < 0 || porcentajeTolerancia > 100){
            throw new IllegalArgumentException("El porcentaje de tolerancia debe estar entre 0 y 100");
        }else {
            AnalizadorFrase a = new AnalizadorFrase(frase);
            int numPalabras = a.getNumeroPalabras();
            int numCorresponden = (numPalabras*100)/porcentajeTolerancia;
            List<String> listaPalabras = a.getPalabras();
            int contador = 0;
            for (String i : listaPalabras){
                if (this.contienePalabra(i)){
                    contador++;
                }
            }
            if (contador>numCorresponden){
                resultado = true;
            }
        }
        return resultado;
    }
}
