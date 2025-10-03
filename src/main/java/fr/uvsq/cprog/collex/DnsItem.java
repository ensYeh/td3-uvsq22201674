package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.AdresseIP;
import fr.uvsq.cprog.collex.FormatException;
import fr.uvsq.cprog.collex.NomMachine;

public class DnsItem {
    private AdresseIP adresse;
    private NomMachine nom;

    public DnsItem(AdresseIP ip, NomMachine n) {
        this.adresse = ip;
        this.nom = n;
    }

    public DnsItem(String s) throws FormatException, BoundsException {
        String[] splitted = s.split("\s");
        this.adresse = new AdresseIP(splitted[0]);
        this.nom = new NomMachine(splitted[1]);
    }

    public AdresseIP getAdresse() {
        return this.adresse;
    }

    public NomMachine getNom() {
        return this.nom;
    }

    public boolean equals(DnsItem other) {
        return this.adresse.equals(other.adresse)
            && this.nom.equals(other.nom);
    }

    public String toString() {
        return String.format(
            "%s %s",
            this.adresse.toString(),
            this.nom.toString()
        );
    }
}
