package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Dns {
    private Properties proprietesBDD = null;
    /**
     * Cette HashMap permet de récupérer un nom de machine à partir d'une adresse en O(1).
     */
    private HashMap<AdresseIP, NomMachine> adresse_nom_map = new HashMap<AdresseIP, NomMachine>();
    /**
     * Cette HashMap permet de récupérer une adresse à partir d'un nom en O(1).
     */
    private HashMap<NomMachine, AdresseIP> nom_adresse_map = new HashMap<NomMachine, AdresseIP>();

    public Dns() throws IOException {
        this.chargerProprietes();

        // On remplie les HashMap avec les DnsItem sauvegardés.
        List<DnsItem> items = this.loadItems();
        for (DnsItem item : items) {
            this.nom_adresse_map.put(item.getNom(), item.getAdresse());
            this.adresse_nom_map.put(item.getAdresse(), item.getNom());
        }
    }

    public void addItem(DnsItem item) throws ExisteDejaException, IOException {
        // `foundByName` et `foundByAdresse` doivent tous les deux
        // soulever une `AucunItemException` pour que le code de cette fonction s'exécute.
        try {
            DnsItem foundByName = this.getItem(item.getNom());
            throw new ExisteDejaException(item.toString());
        } catch(AucunItemException e0) {
            try {
                DnsItem foundByAdress = this.getItem(item.getAdresse());
                throw new ExisteDejaException(item.toString());
            } catch(AucunItemException e1) {
                nom_adresse_map.put(item.getNom(), item.getAdresse());
                adresse_nom_map.put(item.getAdresse(), item.getNom());
                Files.writeString(
                  this.getDatabasePath(),
                  String.format("%s\n", item.toString()),
                  StandardOpenOption.APPEND
                );
            }
        }
    }

    public DnsItem getItem(AdresseIP ip) throws AucunItemException {
        NomMachine nom = this.adresse_nom_map.get(ip);

        if (nom == null) {
            // L'adresse n'est pas dans la BDD
            throw new AucunItemException(ip.toString());
        } else {
            return new DnsItem(ip, nom);
        }
    }

    public DnsItem getItem(NomMachine nom) throws AucunItemException {
        AdresseIP ip = this.nom_adresse_map.get(nom);
        if (ip == null) {
            // Le nom n'est pas dans la BDD
            throw new AucunItemException(nom.toString());
        } else {
            return new DnsItem(ip, nom);
        }
    }

    public List<DnsItem> getItems(String domaine) {
        LinkedList<DnsItem> result = new LinkedList<DnsItem>();
        for (HashMap.Entry<NomMachine, AdresseIP> ligne : this.nom_adresse_map.entrySet()) {
            NomMachine nom = ligne.getKey();
            AdresseIP adresse = ligne.getValue();

            if (nom.getDomaine().equals(domaine)) {
                result.add(new DnsItem(adresse, nom));
            }
        }
        return result;
    }

    public List<DnsItem> loadItems() throws IOException {
        List<String> lines = Files.readAllLines(
          this.getDatabasePath()
        );

        List<DnsItem> toReturn = new ArrayList<DnsItem>();
        for (String line : lines) {
            try {
                DnsItem newItem = new DnsItem(line);
                toReturn.add(newItem);
            } catch(FormatException e) {
              System.out.println("Erreur de format dans la base de données ! Ligne ignorée.");
            } catch(BoundsException e) {
              System.out.println("Adresse IP invalide dans la base de données ! Ligne ignorée.");
            }
        }
        return toReturn;
    }

    public Path getDatabasePath() {
        return Paths.get(this.proprietesBDD.getProperty("filepath"));
    }

    private void chargerProprietes() throws IOException {
      InputStream flux = Files.newInputStream(
        Paths.get("src/main/resources/database.properties")
      );

      this.proprietesBDD = new Properties();
      this.proprietesBDD.load(flux);
    }
}
