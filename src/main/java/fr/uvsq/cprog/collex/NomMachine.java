package fr.uvsq.cprog.collex;

import java.util.Objects;

import fr.uvsq.cprog.collex.FormatException;

public class NomMachine implements Comparable<NomMachine>  {
    private String machine;
    private String domaine;
    private String local;
    
    public NomMachine(final String arg) throws FormatException {
        String[] splitted = arg.split("\\.");
        if (splitted.length != 3) {
            throw new FormatException("machine.domaine.local");
        }
        this.machine = splitted[0];
        this.domaine = splitted[1];
        this.local = splitted[2];
    }

    public String getDomaine() {
        return this.domaine + "." + this.local;
    }

    public String toString() {
        return String.format(
            "%s.%s.%s",
            this.machine,
            this.domaine,
            this.local
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.machine, this.domaine, this.local);
    }

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

    @Override
    public int compareTo(NomMachine other) {
        return this.toString().compareTo(other.toString());
    }
}
