package fr.uvsq.cprog.collex;

/**
 * Commande pour rechercher un nom à partir d'une adresse.
 */
public class RechercheAdresse implements Commande<NomMachine> {
    /**
     * Le `Dns` dans lequel chercher.
     */
    private Dns dns;
    /**
     * L'adresse à rechercher.
     */
    private AdresseIP adresse;

    /**
     * Simple constructeur.
     * @param rechercherDans le `Dns` dans lequel chercher.
     * @param aRechercher l'adresse à rechercher.
     */
    public RechercheAdresse(Dns rechercherDans, AdresseIP aRechercher) {
        this.dns = rechercherDans;
        this.adresse = aRechercher;
    }

    /**
     * Réalise l'action.
     */
    @Override
    public NomMachine executer() throws AucunItemException {
        return this.dns.getItem(this.adresse).getNom();
    }
}
