package model.prank;

import model.mail.Group;
import model.mail.Mail;
import model.mail.Person;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrankGenerator {
    private List<Group> groups;
    private List<Mail> mails;
    private Group victimsList = new Group();
    private List<String> messages = new ArrayList<>();
    static private final int NB_GROUP_MIN = 3;
    static private final String FIN_MESSAGE = "ThisIsTheEnd";

    public List<Mail> getMails () {
        return mails;
    }

    public boolean makeGroups(int nbGroup, FileInputStream fileInputStream) throws IOException {
        groups = new ArrayList<>(nbGroup);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));

        String email;
        while((email = br.readLine())  != null) {
            Person p = new Person(email);
            victimsList.addPerson(p);
        }

        if(victimsList.size() < NB_GROUP_MIN * nbGroup) {
            System.out.println("TEST : " + victimsList.size() + " - " +  NB_GROUP_MIN * nbGroup);
            System.out.println("Erreur, la liste des emails n'est pas assez longue");
            return false;
        }

        for(int j = 0; j < nbGroup; ++j)
            groups.add(new Group());

        while(!victimsList.isEmpty()) {
            for(int j = 0; j < nbGroup; ++j) {
                if(!victimsList.isEmpty())
                    groups.get(j).addPerson(victimsList.pop());
            }
        }
        return true;
    }

    public void makeMails(FileInputStream fileInputStream) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8));

        StringBuilder message = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            while (!line.startsWith(FIN_MESSAGE)) {
                message.append(line).append("\r\n");
                line = br.readLine();
            }
            messages.add(message.toString());
            message = new StringBuilder();
        }

        Collections.shuffle(messages);

        mails = new ArrayList<>(groups.size());

        for (int j = 0; j < groups.size(); ++j)
            mails.add(new Mail());

        for (int i = 0; i < groups.size(); ++i) {
            mails.get(i).setSender(groups.get(i).getListPerson().get(0));
            mails.get(i).setReceivers(groups.get(i).getListPerson().subList(1, groups.get(i).size()));
            mails.get(i).setText(messages.get(i % messages.size()));
        }
    }
}
