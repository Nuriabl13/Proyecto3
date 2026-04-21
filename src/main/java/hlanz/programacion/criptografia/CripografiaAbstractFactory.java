package hlanz.programacion.criptografia;

public interface CripografiaAbstractFactory {
    public CripografiaAbstractFactory getFactory(AlgoritmoCifrado algoritmo);
}