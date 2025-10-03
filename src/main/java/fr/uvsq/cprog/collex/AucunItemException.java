package fr.uvsq.cprog.collex;

public class AucunItemException extends Exception {
    public AucunItemException(String critere) {
        super(String.format("Aucun `DnsItem` pour le critère '%s'.", critere));
    }
}
