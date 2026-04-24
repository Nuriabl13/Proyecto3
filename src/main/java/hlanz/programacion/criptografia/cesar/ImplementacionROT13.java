package hlanz.programacion.criptografia.cesar;

public class ImplementacionROT13 extends ImplementacionCesar{
    ImplementacionROT13(){
        super();
    }

    @Override
    public String cifrar(String texto, String clave) {
        return super.cifrar(texto,"13");
    }

    @Override
    public String descifrador(String texto, String clave) {
       return super.descifrador(texto,"13"); // ya que lo convierte en negativo
    }
}
