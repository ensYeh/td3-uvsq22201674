package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import fr.uvsq.cprog.collex.NomMachine;

import java.util.ArrayList;
import java.util.List;

public class Dns {
    private Properties proprietesBDD = null;
    private List<DnsItem> items;

    public Dns() throws IOException {
        this.chargerProprietes();
        this.items = this.loadItems();
    }

    public DnsItem getItem(AdresseIP ip) {
        for (DnsItem i : this.items) {
            if (i.getAdresse().equals(ip)) {
              return i;
            }
        }

        return null;
    }

    public DnsItem getItem(NomMachine nm) {
        for (DnsItem i : this.items) {
            if (i.getNom().equals(nm)) {
              return i;
            }
        }

        return null;
    }

    public List<DnsItem> loadItems() throws IOException {
        List<String> lines = Files.readAllLines(
          Paths.get(this.proprietesBDD.getProperty("filepath"))
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

    private void chargerProprietes() throws IOException {
      InputStream flux = Files.newInputStream(
        Paths.get("src/main/resources/database.properties")
      );

      this.proprietesBDD = new Properties();
      this.proprietesBDD.load(flux);
    }
}
