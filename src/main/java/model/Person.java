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
     * @return personID String
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
     * @return associatedUsername String
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
     * @return firstName String
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
    public void setGender(String gender) { this.gender = gender; }

    /**
     * @return String
     */
    public String getFatherID() {
        return fatherID;
    }

    /**
     * @param fatherID String
     */
    public void setFatherID(String fatherID) { this.fatherID = fatherID; }

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

    /**
     * Returns true if all the info is the same
     * @param o Person object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof Person) {
            Person oPerson = (Person) o;
            return oPerson.getPersonID().equals(getPersonID()) &&
                    oPerson.getAssociatedUsername().equals(getAssociatedUsername()) &&
                    oPerson.getFirstName().equals(getFirstName()) &&
                    oPerson.getLastName().equals(getLastName()) &&
                    oPerson.getGender().equals(getGender()) &&
                    oPerson.getFatherID().equals(getFatherID()) &&
                    oPerson.getMotherID().equals(getMotherID()) &&
                    oPerson.getSpouseID().equals(getSpouseID());
        } else {
            return false;
        }
    }
}

