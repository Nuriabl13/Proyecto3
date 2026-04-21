package hlanz.programacion.criptoanalisis;

public record HackExito(String textoCifrado, String textoDescifrado, String clve, Idioma idioma) implements HackResult{
}
