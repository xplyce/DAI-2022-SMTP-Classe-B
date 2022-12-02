import model.prank.Prank;
import model.prank.PrankConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
    public static void main(String... args) throws IOException {
        final String victimesFilepath = "./config/victimes.utf8";
        final String messageFilePath = "./config/messages.utf8";
        final String configFilePath = "./config/config.properties";
        Properties property = null;

        try (InputStream input = new FileInputStream(configFilePath)) {
            property = new Properties();
            property.load(input);
        } catch (IOException ex) {
            System.err.println("Erreur lors de la lecture du fichier config.property");
        }

        assert property != null;
        final int nbGroup = Integer.parseInt(property.getProperty("numberOfGroups"));
        final String ADRESSE = property.getProperty("smtpServerAddress");
        final int PORT = Integer.parseInt(property.getProperty("smtpServerPort"));

        PrankConfig prankConfig = new PrankConfig(nbGroup, victimesFilepath, messageFilePath);
        Prank prank = new Prank(prankConfig, ADRESSE, PORT);

        if(!prank.makePrank()) {
            System.out.println("Erreur lors de l'envoie des prankies");
        }
    }
}