package fr.uvsq.cprog.collex;

/**
 * Représente l'état de l'application.
 */
class EtatApp {
	/**
	 * L'ensemble des valeurs possibles pour l'état courant.
	 */
	public enum EtatPossible {
		ACTIVE,
		QUITTEE
	}

	/**
	 * L'état courant de l'application.
	 */
	private EtatPossible etatCourant;

	/**
	 * Initialise l'état courant à `ACTIVE`.
	 */
	public EtatApp() {
		this.etatCourant = EtatPossible.ACTIVE;
	}

	/**
	 * Retourne l'état courant.
	 */
	public EtatPossible getEtatCourant() {
		return this.etatCourant;
	}

	/**
	 * Modifie l'état courant.
	 */
	public void setEtatCourant(EtatPossible nouvelEtat) {
		this.etatCourant = nouvelEtat;
	}
}
