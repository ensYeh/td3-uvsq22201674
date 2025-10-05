package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import org.junit.Test;


public class RechercheAdresseTest {
    @Test
    public void executionSucces() throws Exception {
        Dns dns = new Dns();
        RechercheAdresse recherche = new RechercheAdresse(dns, new AdresseIP(192, 168, 0, 1));
        assertTrue(recherche.executer().equals(new NomMachine("www.uvsq.fr")));
    }

    @Test
    public void executionErreur() throws Exception {
        Dns dns = new Dns();
        RechercheAdresse recherche = new RechercheAdresse(dns, new AdresseIP(100, 56, 65, 31));
        assertThrows(
            AucunItemException.class,
            () -> recherche.executer()
        );
    }
}
