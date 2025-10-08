package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QuitterAppTest {
	@Test
	public void base() {
		EtatApp etat = new EtatApp();
		QuitterApp commande = new QuitterApp(etat);

		assertEquals(etat.getEtatCourant(), EtatApp.EtatPossible.ACTIVE);
		commande.executer();
		assertEquals(etat.getEtatCourant(), EtatApp.EtatPossible.QUITTEE);
	}
}
