package fr.uvsq.cprog.collex;

final class Main {
    private Main() {
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
        System.out.println("Hello, World!");
    }
}
