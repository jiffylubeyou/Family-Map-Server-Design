package requestresponse;

import model.Person;

public class PersonResultArray {
    Person[] data;
    String message;
    public boolean success;

    /**
     * Conttructor that builds the object with the correct info
     * @param data
     * @param message
     * @param success
     */
    public PersonResultArray (Person[] data, String message, boolean success)
    {
        this.data = data;
        this.message = message;
        this.success = success;
    }

    public Person[] getPeople() {
        return data;
    }

    /**
     * @return message String object
     */
    public String getMessage() {
        return message;
    }
}
