package model.mail;

public class Mail {

    private String sender;
    private String[] receivers;
    private String[] cc;
    private String text;

    public Mail() {
        receivers = new String[0];
    }

    public String getSender() {return sender;}
    public void setSender(String sender){this.sender = sender;}

    public String[] getReceivers(){return receivers;}
    public void setReceivers(String[] receivers) {this.receivers = receivers;}

    public String[] getCc() {return cc;}
    public void setCc(String[] cc) {this.cc = cc;}

    public String getText(){return text;}
    public void setText(String text) {this.text = text;}

}
