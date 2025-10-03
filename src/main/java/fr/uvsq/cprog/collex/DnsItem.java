package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.AdresseIP;

public class DnsItem {

    private AdresseIP adresse;
    private NomMachine nom;

    public DnsItem(AdresseIP ip, NomMachine n) {
        this.adresse = ip;
        this.nom = n;
    }

    public String toString() {
        return String.format(
            "%s %s",
            this.adresse.toString(),
            this.nom.toString()
        );
    }
}
