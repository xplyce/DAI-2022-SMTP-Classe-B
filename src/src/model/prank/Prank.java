package ch.heigvd.api.model.prank;

import model.prank.PrankConfig;
import model.prank.PrankGenerator;
import smtp.Client;

import java.io.*;

public class Prank {

    private final Client client;
    private final PrankGenerator prankGenerator = new PrankGenerator();
    private final PrankConfig prankConfig;

    public Prank(PrankConfig prankConfig, String addr, String port) {
        this.prankConfig = prankConfig;
        this.client = new Client(addr, port);
    }

    public boolean makePrank() throws IOException {
        if(!prankGenerator.makeGroups(prankConfig.getNbGroup(), new FileInputStream(prankConfig.getVictimFilePath())))
            return false;
        prankGenerator.makeMails(new FileInputStream(prankConfig.getMessageFilePath()));

        for(int i = 0; i < prankConfig.getNbGroup(); ++i) {
            client.sendMail(prankGenerator.getMails().get(i));
        }
        return true;
    }

}
