package fr.uvsq.cprog.collex;

public class BoundsException extends Exception {
	public BoundsException(int min, int max) {
		super(String.format("La valeur devrait être entre %d et %d.", min, max));
	}
}
