package hlanz.programacion.criptografia.general;

public interface CriptografiaAbstractFactory {
    public abstract CriptografiaAbstractFactory getFactory(AlgoritmoCifrado algoritmo);
}