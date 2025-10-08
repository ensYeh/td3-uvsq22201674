package fr.uvsq.cprog.collex;

class EtatApp {
	public enum EtatPossible {
		ACTIVE,
		QUITTEE
	}

	private EtatPossible etatCourant;

	public EtatApp() {
		this.etatCourant = EtatPossible.ACTIVE;
	}

	public EtatPossible getEtatCourant() {
		return this.etatCourant;
	}

	public void setEtatCourant(EtatPossible nouvelEtat) {
		this.etatCourant = nouvelEtat;
	}
}
