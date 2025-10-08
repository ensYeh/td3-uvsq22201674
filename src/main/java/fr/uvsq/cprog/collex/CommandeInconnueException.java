package fr.uvsq.cprog.collex;

public class CommandeInconnueException extends Exception {
	public CommandeInconnueException(String commande) {
		super(String.format("Commande inconnue : '%s'.", commande));
	}
}
