package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.io.IOException;

public class AjouterItemTest {
	@Test
	public void doubleAjout() throws IOException, FormatException, BoundsException {
		Dns dns = new Dns();
		DnsItem aAjouter = new DnsItem("60.60.50.50 www.nexistepasencore.fr");
		AjouterItem commande = new AjouterItem(dns, aAjouter);
		
		try {
			commande.executer();
			assertThrows(
				ExisteDejaException.class,
				() -> commande.executer()
			);
			
			DnsTest.resetTestDatabase(dns);
		} catch (ExisteDejaException e) {
			System.out.println(e.getMessage());
			fail();
		}
	}
}
