package fr.uvsq.cprog.collex;

import java.util.Objects;

import fr.uvsq.cprog.collex.BoundsException;
import fr.uvsq.cprog.collex.FormatException;

public class AdresseIP implements Comparable<AdresseIP> {
    static final int FIELD_MIN = 0;
    static final int FIELD_MAX = 255; 
    
    /**
    * Représente une adresse IPv4, un octet par champ.
    */
    private int[] fields;

    public AdresseIP(final int a, final int b, final int c, final int d) throws BoundsException {
        int[] asArray = { a, b, c, d };
        this.fields = asArray;
        this.checkBounds();
    }

    public AdresseIP(final String code) throws BoundsException, FormatException, NumberFormatException {
        final FormatException formatException = new FormatException("[0-255].[0-255].[0-255].[0-255]");

        this.fields = new int[4];
        
        final String[] splitted = code.split("\\.");
        
        if (splitted.length != 4) {
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

    private void checkBounds() throws BoundsException {
        for(int b : this.fields) {
            if (b < AdresseIP.FIELD_MIN || b > AdresseIP.FIELD_MAX) {
                throw new BoundsException(AdresseIP.FIELD_MIN, AdresseIP.FIELD_MAX);
            }  
        }
    }

    public String toString() {
        return String.format(
            "%d.%d.%d.%d",
            this.fields[0],
            this.fields[1],
            this.fields[2],
            this.fields[3]
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fields[0], this.fields[1], this.fields[2], this.fields[3]);
    }

    @Override
    public boolean equals(Object other) {
        if (! (other instanceof AdresseIP)) {
            return false;
        }

        AdresseIP casted_other = (AdresseIP) other;
        
        for (int i = 0; i < 4; i++) {
            if (this.fields[i] != casted_other.fields[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compareTo(AdresseIP other) {
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
