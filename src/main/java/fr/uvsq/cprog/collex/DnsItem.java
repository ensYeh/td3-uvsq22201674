package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.AdresseIP;
import fr.uvsq.cprog.collex.FormatException;
import fr.uvsq.cprog.collex.NomMachine;

/**
 * Représente une entrée du serveur DNS.
 */
public class DnsItem {
    /**
     * L'adresse de la machine.
     */
    private AdresseIP adresse;
    /**
     * Le nom de la machine.
     */
    private NomMachine nom;

    /**
     * Simple constructeur.
     * @param ip l'adresse
     * @param n le nom
     */
    public DnsItem(final AdresseIP ip, final NomMachine n) {
        this.adresse = ip;
        this.nom = n;
    }

    /**
     * Constructeur-parseur. Format : '[adresse] [nom]'
     * @param s la `String` à parser.
     */
    public DnsItem(final String s) throws FormatException, BoundsException {
        String[] splitted = s.split("\s");
        this.adresse = new AdresseIP(splitted[0]);
        this.nom = new NomMachine(splitted[1]);
    }

    /**
     * Retourne l'adresse.
     */
    public AdresseIP getAdresse() {
        return this.adresse;
    }

    /**
     * Retourne le nom.
     */
    public NomMachine getNom() {
        return this.nom;
    }

    /**
     * Compare à un objet.
     * @param other l'objet comparé.
     */
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof DnsItem)) {
            return false;
        }
        DnsItem castedOther = (DnsItem) other;
        return this.adresse.equals(castedOther.adresse)
            && this.nom.equals(castedOther.nom);
    }

    /**
     * Renvoie une représentation textuelle.
     */
    @Override
    public String toString() {
        return String.format(
            "%s %s",
            this.adresse.toString(),
            this.nom.toString()
        );
    }
}
