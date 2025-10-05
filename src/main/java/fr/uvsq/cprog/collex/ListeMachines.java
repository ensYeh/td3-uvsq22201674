package fr.uvsq.cprog.collex;

import java.util.ArrayList;

public class ListeMachines implements Commande<ArrayList<DnsItem>> {
    private Dns dns;
    private boolean parametreA;
    private String domaine;

    public ListeMachines(Dns rechercherDans, boolean mode, String listerDans) {
        this.dns = rechercherDans;
        this.parametreA = mode;
        this.domaine = listerDans;
    }

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

    public boolean getParametreA() {
        return this.parametreA;
    }

    public void setParametreA(boolean valeur) {
        this.parametreA = valeur;
    }
}
