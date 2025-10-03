package fr.uvsq.cprog.collex;

public class FormatException extends Exception {
    public FormatException(String formatAttendu) {
        super(String.format("Votre chaîne ne suit pas le format '%s'", formatAttendu));
    }
}
