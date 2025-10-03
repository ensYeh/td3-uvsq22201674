package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
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
    public void doubleInsertion() {
        // TODO: Implémenter ce test
    }
}
