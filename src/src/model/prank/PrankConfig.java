package model.prank;

public class PrankConfig {

    private final int nbGroup;
    private final String victimFilePath;
    private final String messageFilePath;

    public PrankConfig(int n, String victimFilePath, String messageFilePath) {
        nbGroup = n;
        this.victimFilePath = victimFilePath;
        this.messageFilePath = messageFilePath;
    }

    public int getNbGroup() {
        return nbGroup;
    }

    public String getVictimFilePath() {
        return victimFilePath;
    }

    public String getMessageFilePath() {
        return messageFilePath;
    }

}
