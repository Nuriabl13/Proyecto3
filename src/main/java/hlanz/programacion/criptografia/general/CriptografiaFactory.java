package hlanz.programacion.criptografia.general;

public interface CriptografiaFactory {
    public abstract Cifrador getCifrador();
    public abstract Descifrador getDescifrador();
}
