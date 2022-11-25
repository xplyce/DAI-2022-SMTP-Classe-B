package model.mail;

public class Person {
    private final String email;



    public Person(String firstName, String lastName, String email){

        this.email = email;
    }

    String getEmail(){
        return email;
    }
}
