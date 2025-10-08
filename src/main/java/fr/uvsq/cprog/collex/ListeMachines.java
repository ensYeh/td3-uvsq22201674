package fr.uvsq.cprog.collex;

import java.util.ArrayList;

/**
 * Commande permettant de réaliser la liste des machines d'un domaine.
 */
public class ListeMachines implements Commande<ArrayList<DnsItem>> {
    /**
     * Le `Dns` visé.
     */
    private Dns dns;
    /**
     * Si le paramètre -a est activé.
     */
    private boolean parametreA;
    /**
     * Le domaine des machines à lister.
     */
    private String domaine;

    /**
     * Simple constructeur.
     * @param rechercherDans le `Dns` visé
     * @param mode si le paramètre -a est activé
     * @param la domaine des machines à lister
     */
    public ListeMachines(Dns rechercherDans, final boolean mode, final String listerDans) {
        this.dns = rechercherDans;
        this.parametreA = mode;
        this.domaine = listerDans;
    }

    /**
     * Réalise la commande de listage.
     */
    @Override
    public ArrayList<DnsItem> executer() {
        ArrayList<DnsItem> items = new ArrayList<DnsItem>(this.dns.getItems(this.domaine));
        if (this.parametreA) {
            items.sort((item0, item1) -> {
                return item0.getAdresse().compareTo(item1.getAdresse());
            });
        } else {
            items.sort((item0, item1) -> {
                return item0.getNom().compareTo(item1.getNom());
            });
        }

        return items;
    }

    /**
     * Retourne true si le paramètre -a est activé.
     */
    public boolean getParametreA() {
        return this.parametreA;
    }

    /**
     * Modifie l'activation du paramètre -a.
     */
    public void setParametreA(final boolean valeur) {
        this.parametreA = valeur;
    }
}
