package fr.uvsq.cprog.collex;

/**
 * `Exception` représentant l'abscence de résultat pour une recherche.
 */
public class AucunItemException extends Exception {
    /**
     * Formate le message d'erreur.
     * @param critere une représentation de l'item recherché
     */
    public AucunItemException(String critere) {
        super(String.format("Aucun `DnsItem` pour le critère '%s'.", critere));
    }
}
