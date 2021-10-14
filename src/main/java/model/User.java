package model;

public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String personID;

    public User (String username, String password, String email, String firstName, String lastName,
                 String gender, String personID)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.personID = personID;
    }

    /**
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String firstName
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
     * @return String lastname
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
     * @return String gender
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
     * @return String personID
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
     * Returns true if all the info is the same
     * @param o User object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof User) {
            User oUser = (User) o;
            return oUser.getUsername().equals(getUsername()) &&
                    oUser.getPassword().equals(getPassword()) &&
                    oUser.getEmail().equals(getEmail()) &&
                    oUser.getFirstName().equals(getFirstName()) &&
                    oUser.getLastName().equals(getLastName()) &&
                    oUser.getGender().equals(getGender()) &&
                    oUser.getPersonID().equals(getPersonID());
        } else {
            return false;
        }
    }
}


