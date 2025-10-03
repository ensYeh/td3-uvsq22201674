package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;

import fr.uvsq.cprog.collex.FormatException;

public class AdresseIPTest {
    @Test
    public void intervalleTest() {
        assertThrows(
            BoundsException.class,
            () -> new AdresseIP(-5, 100, 100, 100)
        );
    }

    @Test
    public void formatTest() {
        try {
            AdresseIP bienFormee = new AdresseIP("192.168.0.1");

            assertEquals("192.168.0.1", bienFormee.toString());
            assertThrows(
                FormatException.class,
                () -> new AdresseIP("Je suis une adresse malformée !")
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void egalite() {
        AdresseIP left = new AdresseIP("58.65.12.254");
        AdresseIP right = new AdresseIp("058.065.12.254");

        assertTrue(left.equals(right));
    }
}
