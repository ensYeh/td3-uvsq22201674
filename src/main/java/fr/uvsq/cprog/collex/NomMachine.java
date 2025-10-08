package fr.uvsq.cprog.collex;

import java.util.Objects;

import fr.uvsq.cprog.collex.FormatException;

/**
 * Réprésente un nom de machine.
 */
public class NomMachine implements Comparable<NomMachine>  {
    /**
     * La machine en elle-même.
     */
    private String machine;
    /**
     * La première partie du nom de domaine.
     */
    private String domaine;
    /**
     * La qualification du nom de domaine.
     */
    private String local;

    /**
     * Constructeur-parseur.
     * @param arg la `String` contenant le nom de machine
     */
    public NomMachine(final String arg) throws FormatException {
        String[] splitted = arg.split("\\.");
        if (splitted.length != 3) {
            throw new FormatException("machine.domaine.local");
        }
        this.machine = splitted[0];
        this.domaine = splitted[1];
        this.local = splitted[2];
    }

    /**
     * Retourne le nom de domaine complet.
     */
    public String getDomaine() {
        return this.domaine + "." + this.local;
    }

    /**
     * Retourne une représentation textuelle du nom.
     */
    public String toString() {
        return String.format(
            "%s.%s.%s",
            this.machine,
            this.domaine,
            this.local
        );
    }

    /**
     * Sert à pouvoir être utilisé comme clef dans une `HashMap`.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.machine, this.domaine, this.local);
    }

    /**
     * Test l'égalité à un objet.
     * @param other l'objet comparé
     */
    @Override
    public boolean equals(Object other) {
        if (! (other instanceof NomMachine)) {
            return false;
        }
        NomMachine casted_other = (NomMachine) other;
        return this.machine.equals(casted_other.machine)
            && this.domaine.equals(casted_other.domaine)
            && this.local.equals(casted_other.local);
    }

    /**
     * Compare à un objet.
     * @param other l'objet comparé
     */
    @Override
    public int compareTo(NomMachine other) {
        return this.toString().compareTo(other.toString());
    }
}
