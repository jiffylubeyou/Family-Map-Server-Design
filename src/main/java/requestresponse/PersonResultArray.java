package requestresponse;

import model.Person;

public class PersonResultArray {
    Person[] data;
    String message;
    public boolean success;

    public PersonResultArray (Person[] data, String message, boolean success)
    {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public Person[] getPeople() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
