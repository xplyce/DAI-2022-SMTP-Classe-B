package model.mail;

import java.util.List;

public class Mail {

    private String sender;
    private String[] receivers = new String[0];
    private String[] cc = new String[0];
    private String text;

    public String getSender() {
        return sender;
    }

    public void setSender(Person sender){
        this.sender = sender.getEmail();
    }

    public String[] getReceivers(){
        return receivers;
    }
    public void setReceivers(List<Person> receivers) {
        String[] list = new String[receivers.size()];
        for (int i = 0; i < receivers.size(); i++)
            list[i] = receivers.get(i).getEmail();
        this.receivers = list;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
