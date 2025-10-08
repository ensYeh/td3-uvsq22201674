package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;

import fr.uvsq.cprog.collex.ExisteDejaException;

public class AjouterItemTest {
	@Test
	public void doubleAjout() {
		Dns dns = new Dns();
		DnsItem aAjouter = new DnsItem("60.60.50.50 www.nexistepasencore.fr");
		AjouterItem commande = new AjouterItem(dns, aAjouter);
		
		try {
			commande.executer();
			assertThrows(
				ExisteDejaException.class,
				() -> commande.executer()
			);
			
			DnsTest.resetTestDatabase();
		} catch (ExisteDejaException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
