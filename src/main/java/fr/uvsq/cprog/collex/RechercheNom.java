package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.AucunItemException;

public class RechercheNom implements Commande<AdresseIP> {
    private Dns dns;
    private NomMachine nom;

    public RechercheNom(Dns rechercherDans, NomMachine aRechercher) {
        this.dns = rechercherDans;
        this.nom = aRechercher;
    }

    @Override
    public AdresseIP executer() throws AucunItemException {
        return this.dns.getItem(this.nom).getAdresse();
    }
}
