package fr.uvsq.cprog.collex;

/**
 * `Exception` représentant le mauvais format d'une chaîne à parser.
 */
public class FormatException extends Exception {
    /**
     * Formate le message d'erreur.
     * @param formatAttendu une représentation du format attendu
     */
    public FormatException(final String formatAttendu) {
        super(String.format("Votre chaîne ne suit pas le format '%s'", formatAttendu));
    }
}
