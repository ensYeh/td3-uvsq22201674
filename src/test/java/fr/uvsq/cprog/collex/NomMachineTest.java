package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import org.junit.Test;

import fr.uvsq.cprog.collex.FormatException;

public class NomMachineTest {
    @Test
    public void testFormat() {
        try {
            NomMachine nm = new NomMachine("fr.uvsq.sama_gharib");
        } catch(FormatException e) {
            fail();
        }
        assertThrows(
            FormatException.class,
            () -> new NomMachine("Je suis un nom de machine invalide")
        );
    }
}
