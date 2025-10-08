package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;

import java.io.IOException;

public class DnsTUITest {
    @Test
    public void testAffichage() throws IOException {
        Dns dns = new Dns();
        EtatApp etat = new EtatApp();
        DnsTUI tui = new DnsTUI(dns, etat);

        try {
            tui.affiche(null);
            tui.affiche(new AucunItemException("TEST"));
            tui.affiche(new String("TEST"));
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testParsingCommande() throws IOException {
        Dns dns = new Dns();
        EtatApp etat = new EtatApp();
        DnsTUI tui = new DnsTUI(dns, etat);

        try {
            Commande ajout = tui.nextCommande("add 192.168.0.1 www.uvsq.fr");
            Commande adresse = tui.nextCommande("192.168.0.1");
            Commande nom = tui.nextCommande("www.uvsq.fr");
            Commande liste_nom = tui.nextCommande("ls uvsq.fr");
            Commande liste_adresse1 = tui.nextCommande("ls -a uvsq.fr");
            Commande liste_adresse2 = tui.nextCommande("ls uvsq.fr -a");
            Commande quitter1 = tui.nextCommande("quit");
            Commande quitter2 = tui.nextCommande("");

            assertTrue(ajout instanceof AjouterItem);
            assertTrue(adresse instanceof RechercheAdresse);
            assertTrue(nom instanceof RechercheNom);
            assertTrue(liste_nom instanceof ListeMachines);
            assertTrue(liste_adresse1 instanceof ListeMachines);
            assertTrue(liste_adresse2 instanceof ListeMachines);
            assertTrue(quitter1 instanceof QuitterApp);
            assertTrue(quitter2 instanceof QuitterApp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void mauvaisArguments() throws IOException {
        Dns dns = new Dns();
        EtatApp etat = new EtatApp();
        DnsTUI tui = new DnsTUI(dns, etat);

        assertThrows(
            NombreArgumentsException.class,
            () -> tui.nextCommande("add 192.168.0.1 www.uvsq.fr banane")
        );
        assertThrows(
            NombreArgumentsException.class,
            () -> tui.nextCommande("192.168.0.1 banane")
        );
        assertThrows(
            NombreArgumentsException.class,
            () -> tui.nextCommande("www.uvsq.fr banane")
        );
        assertThrows(
            FormatException.class,
            () -> tui.nextCommande("ls uvsq.fr banane")
        );
        assertThrows(
            NombreArgumentsException.class,
            () -> tui.nextCommande("ls uvsq.fr banane papaye")
        );
        assertThrows(
            NombreArgumentsException.class,
            () -> tui.nextCommande("ls -a uvsq.fr banane")
        );
        assertThrows(
            NombreArgumentsException.class,
            () -> tui.nextCommande("quit banane")
        );
        assertThrows(
            CommandeInconnueException.class,
            () -> tui.nextCommande("banane")
        );
    }
}
