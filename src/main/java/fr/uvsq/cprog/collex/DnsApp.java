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
            // Objets utiles.
            Dns dns = new Dns();
            EtatApp etat = new EtatApp();
            DnsTUI tui = new DnsTUI(dns, etat);
            Scanner utilisateur = new Scanner(System.in);

            // Message de bienvenue.
            System.out.println("Bienvenue dans dns-app !");
            System.out.println("Fait par GHARIB ALI BARURA Sama, 22201674.");
            System.out.println("Entrez 'quit' ou une ligne vide pour quitter.");

            // Boucle principale.
            while (etat.getEtatCourant() == EtatApp.EtatPossible.ACTIVE) {
                // Entrée utilisateur.
                System.out.print("> ");
                String entree = utilisateur.nextLine();
                // Parsing, calcul et affichage.
                try {
                    Commande commande = tui.nextCommande(entree);
                    tui.affiche(commande.executer());
                } catch (NumberFormatException e) {
                    System.out.println("ERREUR : Une adresse IPv4 n'est composée que de chiffres.");
                } catch (CommandeInconnueException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Commandes valides :");
                    System.out.println("\t[adresse_IPv4] ........................... Cherche le nom d'une machine.");
                    System.out.println("\t[nom_de_machine] ......................... Cherche l'adresse d'une machine.");
                    System.out.println("\tls [-a] [domaine] ........................ Liste les machines du domaine.");
                    System.out.println("\tadd [adresse_IPv4] [nom_de_machine] ...... Ajoute la machine au DNS.");
                    System.out.println("\tquit ..................................... Stop le programme.");
                } catch (Exception e) {
                    tui.affiche(e);
                }
            }
        } catch (IOException e) {
            // Erreurs au lancement.
            System.out.println("Erreur lors de la lecture de la base de données.");
            System.out.println("Assurez-vous que le fichier indiqué existe.");
        }
    }
}
