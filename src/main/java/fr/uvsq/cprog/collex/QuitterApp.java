package fr.uvsq.cprog.collex;

/**
 * Commande pour quitter l'application.
 */
public class QuitterApp implements Commande<Void> {
	/**
	 * L'état de l'application à modifier.
	 */
	private EtatApp aModifier;

	/**
	 * Simple constructeur.
	 * @param arg l'état à modifier
	 */
	public QuitterApp(EtatApp arg) {
		this.aModifier = arg;
	}

	/**
	 * Réalise l'action.
	 */
	@Override
	public Void executer() {
		System.out.println("Vous quittez l'application.");
		
		this.aModifier.setEtatCourant(
			EtatApp.EtatPossible.QUITTEE
		);

		return null;
	}
}
