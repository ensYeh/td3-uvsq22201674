package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ListeMachinesTest {
    @Test
    public void executionSucces() throws Exception {
        Dns dns = new Dns();
        ListeMachines liste = new ListeMachines(dns, false, "uvsq.fr");

        List<DnsItem> attendu = new ArrayList<DnsItem>();
        attendu.add(new DnsItem("192.168.0.1 www.uvsq.fr"));
        attendu.add(new DnsItem("53.35.16.61 xylophone.uvsq.fr"));

        List<DnsItem> trouve = liste.executer();

        assertTrue(trouve.equals(attendu));

        liste.setParametreA(true);

        trouve = liste.executer();
        Collections.reverse(attendu);

        assertTrue(trouve.equals(attendu));
    }
}
