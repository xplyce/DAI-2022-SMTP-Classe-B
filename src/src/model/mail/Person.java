package model.mail;

public class Person {
    private final String email;
    private final String firstName;
    private final String lastName;


    public Person(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    String getEmail(){
        return email;
    }

    String getFirstName(){
        return firstName;
    }

    String getLastName(){
        return lastName;
    }
}
