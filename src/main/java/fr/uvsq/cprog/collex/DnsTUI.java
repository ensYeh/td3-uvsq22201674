package fr.uvsq.cprog.collex;

import java.util.Arrays;

public class DnsTUI {
	private Dns dns;
	private EtatApp etat;

	public DnsTUI(Dns arg0, EtatApp arg1) {
		this.dns = arg0;
		this.etat = arg1;
	}

	public void affiche(Object e) {
		if (e == null) {
			// Ne rien afficher.
		} else if (e instanceof Exception) {
			Exception err = (Exception) e;
			System.out.println(String.format("ERREUR : \"%s\"", err.getMessage()));
		} else {
			System.out.println(e.toString());
		}
	}

	public Commande nextCommande(String text) throws CommandeInconnueException, FormatException, BoundsException, NombreArgumentsException {
		String[] splited = text.split("\s");

		if (splited.length == 0 || splited[0].isEmpty()) {
			return new QuitterApp(this.etat);
		}

		if (splited[0].equals("add")) {
			if (splited.length == 3) {
				return new AjouterItem(this.dns, new DnsItem(splited[1] + " " + splited[2]));
			} else {
				throw new NombreArgumentsException(3, splited.length);
			}
		} else if (splited[0].equals("ls")) {
			if (splited.length == 2) {
				return new ListeMachines(this.dns, false, splited[1]);
			} else if (splited.length == 3) {
				int optionIndex = Arrays.asList(splited).indexOf("-a");
				if (optionIndex == -1) {
					throw new FormatException("ls -a [domaine] ou ls [domaine] -a");
				} else {
					int domaineIndex = optionIndex == 1 ? 2 : 1;
					return new ListeMachines(this.dns, true, splited[domaineIndex]);
				}
			} else {
				throw new NombreArgumentsException(2, splited.length);
			}
		} else if (splited[0].split("\\.").length == 3) {
			if (splited.length == 1) {
				return new RechercheNom(this.dns, new NomMachine(splited[0]));
			} else {
				throw new NombreArgumentsException(1, splited.length);
			}
		} else if (splited[0].split("\\.").length == 4) {
			if (splited.length == 1) {
				return new RechercheAdresse(this.dns, new AdresseIP(splited[0]));
			} else {
				throw new NombreArgumentsException(1, splited.length);
			}
		} else if (splited[0].equals("quit")) {
			if (splited.length == 1) {
				return new QuitterApp(this.etat);
			} else {
				throw new NombreArgumentsException(1, splited.length);
			}
		} else {
			throw new CommandeInconnueException(splited[0]);
		}
	}

    public void nextCommande() {
        //TODO
    }
}
