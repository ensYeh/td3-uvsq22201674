package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.io.IOException;

public class DnsTUITest {
    @Test
    public void testParsingCommande() throws IOException {
        Dns dns = new Dns();
        EtatApp etat = new EtatApp();
        DnsTUI tui = new DnsTUI(dns, etat);

        try {
            Commande ajout = tui.parserCommande("add 192.168.0.1 www.uvsq.fr");
            Commande adresse = tui.parserCommande("192.168.0.1");
            Commande nom = tui.parserCommande("www.uvsq.fr");
            Commande liste_nom = tui.parserCommande("ls uvsq.fr");
            Commande liste_adresse = tui.parserCommande("ls -a uvsq.fr");
            Commande quitter = tui.parserCommande("quit");

            assertTrue(ajout instanceof AjouterItem);
            assertTrue(adresse instanceof RechercheAdresse);
            assertTrue(nom instanceof RechercheNom);
            assertTrue(liste_nom instanceof ListeMachines);
            assertTrue(liste_adresse instanceof ListeMachines);
            assertTrue(quitter instanceof QuitterApp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
