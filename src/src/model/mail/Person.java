package model.mail;

public class Person {
    private String email;

    public Person (String email){
        this.email = email;
    }

    public Person() {}

    String getEmail(){
        return email;
    }
}
