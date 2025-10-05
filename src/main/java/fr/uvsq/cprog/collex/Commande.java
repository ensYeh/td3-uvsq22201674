package fr.uvsq.cprog.collex;

/**
 * Cette classe représente une commande exécutable.
 */
public interface Commande<TypeRetour> {
	public TypeRetour executer() throws Exception;
}
