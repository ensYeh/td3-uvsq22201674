package fr.uvsq.cprog.collex;

public class NombreArgumentsException extends Exception {
	public NombreArgumentsException(int expected, int found) {
		super(String.format("Nombre d'arguments invalide. Attendu : %d, trouvé : %d.", expected, found));
	}
}
