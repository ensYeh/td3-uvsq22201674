package fr.uvsq.cprog.collex;

/**
 * `Exception` représentant l'existance préalable d'un item inséré.
 */
public class ExisteDejaException extends Exception {
    /**
     * Formate le message d'erreur.
     * @param field une représentation de l'item recherché
     */
    public ExisteDejaException(final String field) {
        super(String.format("Le champ '%s' existe déjà.", field));
    }
}
