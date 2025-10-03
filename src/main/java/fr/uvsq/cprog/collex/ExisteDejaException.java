package fr.uvsq.cprog.collex;

public class ExisteDejaException extends Exception {
    public ExisteDejaException(String field) {
        super(String.format("Le champ '%s' existe déjà.", field));
    }
}
