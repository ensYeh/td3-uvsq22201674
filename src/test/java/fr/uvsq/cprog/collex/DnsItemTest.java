package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

public class DnsItemTest {
    @Test
    public void testConstructeur() {
        try {
            DnsItem d = new DnsItem(
                new AdresseIP("192.168.0.1"),
                new NomMachine("fr.uvsq.sama")
            );
        } catch(Exception e) {
            fail();
        }
    }
}
