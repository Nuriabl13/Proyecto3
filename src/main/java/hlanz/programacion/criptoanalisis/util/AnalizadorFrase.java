package hlanz.programacion.criptoanalisis.util;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorFrase {
    private String[] palabras;
public AnalizadorFrase(String frase){
    this.palabras=frase.split(" ");
}
public int getNumeroPalabras(){
    return  this.palabras.length;
}
public List<String> getPalabras(){
    List<String> listaPalabras = new ArrayList<>();
    listaPalabras.addAll(List.of(this.palabras));
    return listaPalabras;
}
}
