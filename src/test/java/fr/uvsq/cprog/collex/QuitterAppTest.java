package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class QuitterAppTest {
	@Test
	public void base() {
		EtatApp etat = new EtatApp();
		QuitterApp commande = new QuitterApp(etat);

		assertEquals(etat.equals(EtatApp.Active));
		commande.executer();
		assertTrue(etat.equals(EtatApp.Quittee));
	}
}
