package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DnsTUITest {
    @Test
    public void testParsingCommande() throws IOException {
        DnsTUI tui = new DnsTUI();
    
        Commande ajout = tui.parserCommande("add 192.168.0.1 www.uvsq.fr");
        Commande adresse = tui.parserCommande("192.168.0.1");
        Commande nom = tui.parserCommande("www.uvsq.fr");
        Commande liste_nom = tui.parserCommande("ls uvsq.fr");
        Commande liste_adresse = tui.parserCommande("ls -a uvsq.fr");
        Commande quitter = tui.parserCommande("quit");

        assertTrue(ajout instanceof AjouterItem);
        assertTrue(adresse instanceof RechercherAdresse);
        assertTrue(nom instanceof RechercherNom);
        assertTrue(liste_nom instanceof ListeMachines);
        assertTrue(liste_adresse instanceof ListeMachines);
        assertTrue(quitter instanceof QuitterApp);
    }
}
