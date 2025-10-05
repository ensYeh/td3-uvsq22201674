package fr.uvsq.cprog.collex;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;
import org.junit.Test;


public class ListeMachinesTest {
    @Test
    public void executionSucces() throws Exception {
        Dns dns = new Dns();
        ListeMachines liste = new ListeMachines(dns, false);
        
        List<DnsItem> attendu = new LinkedList<DnsItem>();
        attendu.add(new DnsItem("192.168.0.1 www.uvsq.fr"));
        attendu.add(new DnsItem("53.35.16.61 www.xylophone.fr"));

        List<DnsItem> trouve = liste.executer();
        assertTrue(trouve.equals(attendu));
        trouve.setParametreA(true);
        assertTrue(trouve.equels(attendu.reverse()));
    }
}
