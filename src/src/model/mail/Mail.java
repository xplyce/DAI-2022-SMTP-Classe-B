package model.mail;

public class Mail {

    private Person sender;
    private Group receivers;
    private Group cc;
    private String subject;
    private String text;

    public Mail() {
        receivers = new Group();
    }

    public Person getSender() {return sender;}
    public void setSender(Person sender){this.sender = sender;}

    public Group getReceivers(){return receivers;}
    public void setReceivers(Group receivers) {this.receivers = receivers;}

    public Group getCc() {return cc;}
    public void setCc(Group cc) {this.cc = cc;}

    public String getSubject(){return subject;}
    public void setSubject(String subject) {this.subject = subject;}

    public String getText(){return text;}
    public void setText(String text) {this.text = text;}

}
