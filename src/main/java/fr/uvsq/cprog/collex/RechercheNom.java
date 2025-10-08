package fr.uvsq.cprog.collex;

/**
 * Représente la commande pour rechercher une machine avec son nom.
 */
public class RechercheNom implements Commande<AdresseIP> {
    /**
     * Le Dns dans lequel rechercher.
     */
    private Dns dns;
    /**
     * Le nom à rechercher.
     */
    private NomMachine nom;

    /**
     * Simple constructeur.
     * @param rechercherDans le dns dans lequel chercher.
     * @param le nom de la machine à rechercher.
     */
    public RechercheNom(Dns rechercherDans, NomMachine aRechercher) {
        this.dns = rechercherDans;
        this.nom = aRechercher;
    }

    /**
     * Réalise l'action.
     */
    @Override
    public AdresseIP executer() throws AucunItemException {
        return this.dns.getItem(this.nom).getAdresse();
    }
}
