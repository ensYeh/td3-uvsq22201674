package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import fr.uvsq.cprog.collex.AucunItemException;
import fr.uvsq.cprog.collex.RechercheNom;

public class RechercheNomTest {
    @Test
    public void executionSucces() {
        Dns dns = new Dns();
        RechercheNom recherche = new RechercheNom(dns, new NomMachine("www.uvsq.fr"));
        assertTrue(recherche.execute().equals("192.168.0.1"));
    }

    @Test
    public void executionErreur() {
        Dns dns = new Dns();
        RechercheNom recherche = new RechercheNom(dns, new NomMachine("www.lescarottessontcuites.fr"));
        assertThrows(
            AucunItemException.class,
            () -> recherche.execute().equals("192.168.0.1")
        );
    }
}
