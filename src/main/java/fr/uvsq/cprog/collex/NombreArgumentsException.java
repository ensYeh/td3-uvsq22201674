package fr.uvsq.cprog.collex;

/**
 * Représente l'`Exception` d'une commande avec trop ou pas assez d'arguments.
 */
public class NombreArgumentsException extends Exception {

	/**
	 * Formate le message.
	 * @param expected le nombre d'arguments attendu
	 * @param found le nombre d'arguments trouvé
	 */
	public NombreArgumentsException(int expected, int found) {
		super(String.format("Nombre d'arguments invalide. Attendu : %d, trouvé : %d.", expected, found));
	}
}
