package fr.uvsq.cprog.collex;

import java.util.Objects;

import fr.uvsq.cprog.collex.BoundsException;
import fr.uvsq.cprog.collex.FormatException;

/**
 * Contient une représentation d'adresse IPv4.
 */
public class AdresseIP implements Comparable<AdresseIP> {
    /**
     * La valeur minimale des champs de l'adresse.
     */
    static final int FIELD_MIN = 0;
    /**
     * La valeur maximale des champs de l'adresse.
     */
    static final int FIELD_MAX = 255; 
    
    /**
    * Représente une adresse IPv4, un octet par champ.
    */
    private int[] fields;

    /**
     * Construit une adresse à partir de ses champs.
     * @param a premier octet
     * @param b deuxieme octet
     * @param c troisieme octet
     * @param d quatrième octet
     */
    public AdresseIP(final int a, final int b, final int c, final int d) throws BoundsException {
        int[] asArray = { a, b, c, d };
        this.fields = asArray;
        this.checkBounds();
    }

    /**
     * Parse une adresse.
     * @param code l'adresse au format textuel
     */
    public AdresseIP(final String code) throws BoundsException, FormatException, NumberFormatException {
        final FormatException formatException = new FormatException("[0-255].[0-255].[0-255].[0-255]");

        this.fields = new int[4];
        
        final String[] splitted = code.split("\\.");
        
        if (splitted.length != 4) {
            // Ce n'est pas une IPv4, on lève une erreur de format.
            for (String s : splitted) {
                System.out.println(s);
            }
            throw formatException;
        }
        
        for (int i = 0; i < 4; i++) {
            this.fields[i] = Integer.parseInt(splitted[i]);
        }

        this.checkBounds();
    }

    /**
     * Vérifie que chaque champ est codable sur un octet.
     */
    private void checkBounds() throws BoundsException {
        for(int b : this.fields) {
            if (b < AdresseIP.FIELD_MIN || b > AdresseIP.FIELD_MAX) {
                throw new BoundsException(AdresseIP.FIELD_MIN, AdresseIP.FIELD_MAX);
            }  
        }
    }

    /**
     * Retourne au format octet par octet base dix.
     */
    public String toString() {
        return String.format(
            "%d.%d.%d.%d",
            this.fields[0],
            this.fields[1],
            this.fields[2],
            this.fields[3]
        );
    }

    /**
     * Sert à être stockable dans une `HashMap`.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.fields[0], this.fields[1], this.fields[2], this.fields[3]);
    }

    /**
     * Compart les champs un par un.
     * @param l'objet comparé
     */
    @Override
    public boolean equals(Object other) {
        if (! (other instanceof AdresseIP)) {
            // Une adresse IP ne peut être égale qu'à une adresse IP.
            return false;
        }

        AdresseIP casted_other = (AdresseIP) other;

        // On compare champ à champ.
        for (int i = 0; i < 4; i++) {
            if (this.fields[i] != casted_other.fields[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Permet de trier une liste d'adresses.
     * @param l'adresse comparée
     */
    @Override
    public int compareTo(AdresseIP other) {
        // On compare champ à champ
        // (On considère que le bit le plus significatif
        //  est à gauche)
        for (int i = 0; i < 4; i++) {
            if (this.fields[i] < other.fields[i]) {
                return -1;
            } else if (this.fields[i] > other.fields[i]) {
                return 1;
            }
        }
        return 0;
    }
}
