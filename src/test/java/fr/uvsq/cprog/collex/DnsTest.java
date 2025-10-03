package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.io.IOException;

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
    public void doubleInsertion() {
        // TODO: Implémenter ce test
    }
}
