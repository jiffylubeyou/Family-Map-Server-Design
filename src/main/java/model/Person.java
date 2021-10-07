package model;

public class Person {
    private String personID;
    private String associatedUsername;
    private String firstName;
    private String lastName;
    private String gender;
    private String fatherID;
    private String motherID;
    private String spouseID;

    public Person (String personID, String associatedUsername, String firstName, String lastName,
                   String gender, String fatherID, String motherID, String spouseID)
    {
        this.personID = personID;
        this.associatedUsername = associatedUsername;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.fatherID = fatherID;
        this.motherID = motherID;
        this.spouseID = spouseID;
    }


    /**
     * @return String
     */
    public String getPersonID() {
        return personID;
    }

    /**
     * @param personID String
     */
    public void setPersonID(String personID) {
        this.personID = personID;
    }

    /**
     * @return String
     */
    public String getAssociatedUsername() {
        return associatedUsername;
    }

    /**
     * @param associatedUsername String
     */
    public void setAssociatedUsername(String associatedUsername) {
        this.associatedUsername = associatedUsername;
    }

    /**
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName String
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName String
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender String
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String
     */
    public String getFatherID() {
        return fatherID;
    }

    /**
     * @param fatherID String
     */
    public void setFatherID(String fatherID) {
        this.fatherID = fatherID;
    }

    /**
     * @return String
     */
    public String getMotherID() {
        return motherID;
    }

    /**
     * @param motherID String
     */
    public void setMotherID(String motherID) {
        this.motherID = motherID;
    }

    /**
     * @return String
     */
    public String getSpouseID() {
        return spouseID;
    }

    /**
     * @param spouseID String
     */
    public void setSpouseID(String spouseID) {
        this.spouseID = spouseID;
    }
}

