package hlanz.programacion.criptoanalisis.cesar;

import hlanz.programacion.criptoanalisis.HackResult;
import hlanz.programacion.criptoanalisis.Hackeador;

public class CesarHacker implements Hackeador {
    protected List<Idioma> idiomasPosibles;
    protected int porcentajeTolerancia;

    CesarHacker(int porcentajeTolerancia){

    }

    @Override
    public HackResult descifrar(String texto) {
        return null;
    }
}
