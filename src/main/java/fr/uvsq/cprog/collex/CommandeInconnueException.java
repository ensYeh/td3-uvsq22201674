package fr.uvsq.cprog.collex;

/**
 * `Exception` représentant l'abscence de commande.
 */
public class CommandeInconnueException extends Exception {

    /**
     * Formate le message d'erreur.
     * @param commande une représentation de la mauvaise commande
     */
	public CommandeInconnueException(String commande) {
		super(String.format("Commande inconnue : '%s'.", commande));
	}
}
