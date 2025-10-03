package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import fr.uvsq.cprog.collex.AucunItemException;
import fr.uvsq.cprog.collex.BoundsException;
import fr.uvsq.cprog.collex.ExisteDejaException;
import fr.uvsq.cprog.collex.FormatException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DnsTest {
    @Test
    public void testConstructeur() {
        try {
            Dns d = new Dns();
        } catch (IOException e) {
            System.out.println(String.format("Erreur : %s", e.getMessage()));
            fail();
        }
    }

    @Test
    public void chargement() throws Exception {
        Dns dns = new Dns();
        List<DnsItem> loaded = dns.loadItems();
        
        DnsItem found = loaded.iterator().next();
        DnsItem expected = new DnsItem("192.168.0.1 www.uvsq.fr");
        
        assertTrue(found.equals(expected));
    }

    @Test
    public void recuperationSpecifique() throws FormatException, BoundsException, IOException, AucunItemException {
        Dns dns = new Dns();
        DnsItem expected = new DnsItem("192.168.0.1 www.uvsq.fr");
        DnsItem found0 = dns.getItem(new AdresseIP(192, 168, 0, 1));
        DnsItem found1 = dns.getItem(new NomMachine("www.uvsq.fr"));

        assertTrue(expected.equals(found0));
        assertTrue(expected.equals(found1));
    }

    @Test
    public void recuperationDomaine() throws FormatException, BoundsException, IOException {
        Dns dns = new Dns();
        DnsItem expected = new DnsItem("192.168.0.1 www.uvsq.fr");
        List<DnsItem> loaded = dns.getItems("uvsq.fr");
        DnsItem found = loaded.iterator().next();

        assertTrue(expected.equals(found));
    }

    @Test
    public void simpleInsertion() throws IOException, FormatException, BoundsException {
        Dns dns = new Dns();
        try {
            dns.addItem(
                new DnsItem("76.16.0.1 www.banana.fr")
            );
        } catch (ExisteDejaException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void doubleInsertion() throws IOException {
        Dns dns = new Dns();
        assertThrows(
            ExisteDejaException.class,
            () -> dns.addItem(new DnsItem("192.168.0.1 www.uvsq.fr"))
        );
    }
}
