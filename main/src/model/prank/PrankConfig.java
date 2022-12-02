package model.prank;

public class PrankConfig {

    private final int nbGroup;
    private final String victimesFilePath;
    private final String messageFilePath;

    public PrankConfig(int n, String victimesFilePath, String messageFilePath) {
        nbGroup = n;
        this.victimesFilePath = victimesFilePath;
        this.messageFilePath = messageFilePath;
    }

    public int getNbGroup() {
        return nbGroup;
    }

    public String getVictimesFilePath() {
        return victimesFilePath;
    }

    public String getMessageFilePath() {
        return messageFilePath;
    }

}
