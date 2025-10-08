package fr.uvsq.cprog.collex;

import java.util.Scanner;
import java.io.IOException;


/**
 * Interface en ligne de commande simulant un serveur DNS.
 */
final class DnsApp {
    /**
     * Constructeur par défaut désactivé.
     */
    private DnsApp() {
        throw new UnsupportedOperationException(
            "La classe main est une classe utilitaire"
            + "elle ne peut pas être instanciée."
        );
    }

    /**
    * Lance l'application en ligne de commande.
    * @param args les arguments de la ligne de commande.
    */
    public static void main(final String[] args) {
        try {
            Dns dns = new Dns();
            EtatApp etat = new EtatApp();
            DnsTUI tui = new DnsTUI(dns, etat);
            Scanner utilisateur = new Scanner(System.in);

            System.out.println("Bienvenue dans dns-app !");
            System.out.println("Fait par GHARIB ALI BARURA Sama, 22201674.");
            System.out.println("Entrez 'quit' ou une ligne vide pour quitter.");
            
            while (etat.getEtatCourant() == EtatApp.EtatPossible.ACTIVE) {
                System.out.print("> ");
                String entree = utilisateur.nextLine();
                try {
                    Commande commande = tui.nextCommande(entree);
                    tui.affiche(commande.executer());
                } catch (Exception e) {
                    tui.affiche(e);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture de la base de données.");
            System.out.println("Assurez-vous que le fichier indiqué existe.");
        }
    }
}
