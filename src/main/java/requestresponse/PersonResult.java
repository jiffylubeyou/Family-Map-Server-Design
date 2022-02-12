package requestresponse;

public class PersonResult {
    String associatedUsername;
    String personID;
    String firstName;
    String lastName;
    String gender;
    String fatherID;
    String motherID;
    String spouseID;
    String message;
    public boolean success;

    /**
     * Constructor that builds the object with the correct info
     * @param associatedUsername
     * @param personID
     * @param firstName
     * @param lastName
     * @param gender
     * @param fatherID
     * @param motherID
     * @param spouseID
     * @param message
     * @param success
     */
    public PersonResult(String associatedUsername, String personID, String firstName, String lastName,
                        String gender, String fatherID, String motherID, String spouseID, String message, boolean success)
    {
        this.associatedUsername = associatedUsername;
        this.personID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.fatherID = fatherID;
        this.motherID = motherID;
        this.spouseID = spouseID;
        this.message = message;
        this.success = success;
    }
}
