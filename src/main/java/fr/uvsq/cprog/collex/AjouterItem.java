package fr.uvsq.cprog.collex;

import java.io.IOException;

public class AjouterItem implements Commande<Void> {
	private Dns dns;
	private DnsItem aAjouter;

	public AjouterItem(Dns arg0, DnsItem arg1) {
		this.dns = arg0;
		this.aAjouter = arg1;
	}

	@Override
	public Void executer() throws ExisteDejaException, IOException {
		this.dns.addItem(this.aAjouter);
		return null;
	}
}
