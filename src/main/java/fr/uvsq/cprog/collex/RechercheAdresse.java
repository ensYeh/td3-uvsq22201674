package fr.uvsq.cprog.collex;

public class RechercheAdresse implements Commande<NomMachine> {
    private Dns dns;
    private AdresseIP adresse;

    public RechercheAdresse(Dns rechercherDans, AdresseIP aRechercher) {
        this.dns = rechercherDans;
        this.adresse = aRechercher;
    }

    @Override
    public NomMachine executer() throws AucunItemException {
        return this.dns.getItem(this.adresse).getNom();
    }
}
