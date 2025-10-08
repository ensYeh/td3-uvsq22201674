package fr.uvsq.cprog.collex;

import java.io.IOException;

/**
 * Commande pour ajouter une entrée à la BDD.
 */
public class AjouterItem implements Commande<Void> {
	/**
	 * Le DNS dont la BDD est visée.
	 */
	private Dns dns;
	/**
	 * L'item à ajouter.
	 */
	private DnsItem aAjouter;

	/**
	 * Constructeur type.
	 * @param arg0 le dns visé
	 * @param arg1 l'item à ajouter
	 */
	public AjouterItem(Dns arg0, DnsItem arg1) {
		this.dns = arg0;
		this.aAjouter = arg1;
	}

	/**
	 * Réalise l'ajout.
	 */
	@Override
	public Void executer() throws ExisteDejaException, IOException {
		this.dns.addItem(this.aAjouter);
		return null;
	}
}
