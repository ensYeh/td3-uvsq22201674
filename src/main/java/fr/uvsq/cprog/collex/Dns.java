package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Properties;
import java.util.stream.Collectors;

import fr.uvsq.cprog.collex.AucunItemException;
import fr.uvsq.cprog.collex.ExisteDejaException;
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

    public void addItem(DnsItem item) throws ExisteDejaException, IOException {
        // `foundByName` et `foundByAdresse` doivent tous les deux
        // soulever une `AucunItemException` pour que le code de cette fonction s'exécute.
        try {
            DnsItem foundByName = this.getItem(item.getNom());
            throw new ExisteDejaException(item.toString());
        } catch(AucunItemException e0) {
            try {
                DnsItem foundByAdress = this.getItem(item.getAdresse());
            } catch(AucunItemException e1) {
                items.add(item);
                Files.writeString(
                  Paths.get(this.proprietesBDD.getProperty("filepath")),
                  String.format("%s", item.toString()),
                  StandardOpenOption.APPEND
                );
            }
        }
    }

    public DnsItem getItem(AdresseIP ip) throws AucunItemException {
        for (DnsItem i : this.items) {
            if (i.getAdresse().equals(ip)) {
              return i;
            }
        }

        throw new AucunItemException(ip.toString());
    }

    public DnsItem getItem(NomMachine nm) throws AucunItemException {
        for (DnsItem i : this.items) {
            if (i.getNom().equals(nm)) {
              return i;
            }
        }

        throw new AucunItemException(nm.toString());
    }

    public List<DnsItem> getItems(String domaine) {
        return items
            .stream()
            .filter((DnsItem item) -> {
              return item.getNom().getDomaine().equals(domaine);
            })
            .collect(Collectors.toList());
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
