package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.FormatException;

public class NomMachine {
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

    public String toString() {
        return String.format(
            "%s.%s.%s",
            this.machine,
            this.domaine,
            this.local
        );
    }

    public boolean equals(final NomMachine other) {
        return this.machine.equals(other.machine)
            && this.domaine.equals(other.domaine)
            && this.local.equals(other.local);
    }
}
