package model;

import model.Person;

public class Mail {

    private Person sender;
    private Group receivers;
    private String subject;
    private String text;

    public Mail() {
        receivers = new Group();
    }
}
