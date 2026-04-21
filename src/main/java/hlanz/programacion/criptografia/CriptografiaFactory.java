package hlanz.programacion.criptografia;

public interface CriptografiaFactory {
    public Cifrador getCifrador();
    public Descifrador getDescifrador();
}
