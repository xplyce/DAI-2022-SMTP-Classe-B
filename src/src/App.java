import model.prank.Prank;
import model.prank.PrankConfig;
import java.io.IOException;

public class App {
    public static void main(String ... args) throws IOException {
        final int nbGroup               = 3;
        final String victimesFilepath   = "src/config/victimes.utf8";
        final String messageFilePath    = "src/config/messages.ASC";
        final String ADRESSE            = "localhost";
        final int PORT                  = 25;

        PrankConfig prankConfig = new PrankConfig(nbGroup, victimesFilepath, messageFilePath);
        Prank prank = new Prank(prankConfig, ADRESSE, PORT);

        if(!prank.makePrank())
            System.out.println("Erreur lors de l'envoie des prankies");
    }
}