package hlanz.programacion.criptografia.cesar;

import hlanz.programacion.criptoanalisis.util.AnalizadorFrase;
import hlanz.programacion.criptografia.general.Cifrador;
import hlanz.programacion.criptografia.general.Descifrador;

import java.util.List;

public  class ImplementacionCesar implements Cifrador , Descifrador {
    ImplementacionCesar(){
    }
    protected static char getLetraDesplazada(char letra, int desplazamiento) {
        if (letra < 65 || letra > 90) {
            throw new IllegalArgumentException("Solo se pueden desplazar letras mayúsculas");
        }


        int nuevaLetra = letra + desplazamiento;


        if (nuevaLetra > 90) {

            nuevaLetra = nuevaLetra - 26;
        }

        else if (nuevaLetra < 65 ) {

            nuevaLetra = nuevaLetra + 26;
        }

        return (char) nuevaLetra;
    }
protected static String desplazarPalabra(String palabra, int desplazamiento) {
        String palabraMayus = palabra.toUpperCase();
        StringBuilder palabraDesplazada = new StringBuilder();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = ImplementacionCesar.getLetraDesplazada(palabraMayus.charAt(i), desplazamiento);
            palabraDesplazada.append(letra);
        }
        return palabraDesplazada.toString();
    }

    protected static String desplazarLetrasFrases(String frase, int desplazamiento) {
        AnalizadorFrase a = new AnalizadorFrase(frase);
        List<String> palabras = a.getPalabras();
        StringBuilder p = new StringBuilder();
        for (int i = 0; i < a.getNumeroPalabras(); i++) {
            String palabra = palabras.get(i);
            String palabraDesplazada = ImplementacionCesar.desplazarPalabra(palabra, desplazamiento);
            if (!(palabras.indexOf(palabra) == palabras.size() - 1)) {
                p.append(palabraDesplazada+" ");
            } else {
                p.append(palabraDesplazada);
            }
        }
        return p.toString();
    }

    @Override
    public String cifrar(String texto, String clave) {
        int c = Integer.parseInt(clave);
        if (c < 0){
            throw new IllegalArgumentException("La clave debe ser un numero positivo");
        }
        return ImplementacionCesar.desplazarLetrasFrases(texto,c);
    }

    @Override
    public String descifrador(String texto, String clave) {
        int c = Integer.parseInt(clave);
        if (c < 0){
            throw new IllegalArgumentException("La clave debe ser un numero positivo");
        }
        return ImplementacionCesar.desplazarLetrasFrases(texto,-c);

        // this.cifrar(texto,"-"+clave); --> no se si esta bien
    }
}
