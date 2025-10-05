package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import fr.uvsq.cprog.collex.AucunItemException;
import fr.uvsq.cprog.collex.RechercheNom;

public class RechercheNomTest {
    @Test
    public void executionSucces() throws Exception {
        Dns dns = new Dns();
        RechercheNom recherche = new RechercheNom(dns, new NomMachine("www.uvsq.fr"));
        assertTrue(recherche.executer().equals(new AdresseIP("192.168.0.1")));
    }

    @Test
    public void executionErreur() throws Exception {
        Dns dns = new Dns();
        RechercheNom recherche = new RechercheNom(dns, new NomMachine("www.lescarottessontcuites.fr"));
        assertThrows(
            AucunItemException.class,
            () -> recherche.executer().equals("192.168.0.1")
        );
    }
}
