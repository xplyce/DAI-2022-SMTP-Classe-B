import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Person> listPerson;



    public Group(){
        listPerson = new ArrayList<Person>();
    }

    public Group(List<Person> listPerson){
        this.listPerson = listPerson;
    }

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void addPerson(Person n){
        listPerson.add(n);
    }


}
