package fr.uvsq.cprog.collex;

/**
 * Cette classe représente une commande exécutable.
 */
public interface Commande<TypeRetour> {
	/**
	 * Méthode à appeler pour réaliser la commande.
	 */
	public TypeRetour executer() throws Exception;
}
