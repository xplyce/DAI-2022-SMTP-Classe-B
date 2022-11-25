package model.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Group {
    private List<Person> listPerson;



    public Group(){
        listPerson = new ArrayList<>();
    }

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void addPerson(Person n){
        listPerson.add(n);
    }

    public int size() {
        return listPerson.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Person pop() {
        Person tmp = new Person();
        try {
            if (listPerson.size() > 0) {
                tmp = listPerson.get(0);
                listPerson.remove(0);
            } else
                throw new NullPointerException("Can not pop a Person from empty Group");
        } catch (NullPointerException ex) {
            System.out.println(ex);
        }
        return tmp;
    }

}
