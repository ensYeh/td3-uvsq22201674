package fr.uvsq.cprog.collex;

/**
 * `Exception` levée quand un nombre est hors de limites imposées.
 */
public class BoundsException extends Exception {

	/**
     * Formate le message d'erreur.
     * @param min la limite basse
     * @param max la limite haute
     */
	public BoundsException(int min, int max) {
		super(String.format("La valeur devrait être entre %d et %d.", min, max));
	}
}
