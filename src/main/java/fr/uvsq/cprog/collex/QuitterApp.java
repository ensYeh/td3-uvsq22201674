package fr.uvsq.cprog.collex;

public class QuitterApp implements Commande<Void> {
	private EtatApp aModifier;

	public QuitterApp(EtatApp arg) {
		this.aModifier = arg;
	}

	@Override
	public Void executer() {
		this.aModifier.setEtatCourant(
			EtatApp.EtatPossible.QUITTEE)
		;

		return null;
	}
}
