package model;

public class Event {
    private String eventID;
    private String associatedUsername;
    private String personID;
    private float latitude;
    private float longitude;
    private String country;
    private String city;
    private String eventType;
    private int year;

    public Event(String eventID, String username, String personID, float latitude, float longitude,
                 String country, String city, String eventType, int year) {
        this.eventID = eventID;
        this.associatedUsername = username;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
    }


    /**
     * @return string eventID
     */
    public String getEventID() {
        return eventID;
    }


    /**
     * @param eventID String
     */
    public void setEventID(String eventID) {
        this.eventID = eventID;
    }


    /**
     * @return String username
     */
    public String getUsername() {
        return associatedUsername;
    }


    /**
     * @param username String
     */
    public void setUsername(String username) {
        this.associatedUsername = username;
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
     * @return float latitude
     */
    public float getLatitude() {
        return latitude;
    }


    /**
     * @param latitude float
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }


    /**
     * @return latitude float
     */
    public float getLongitude() {
        return longitude;
    }


    /**
     * @param longitude float
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }


    /**
     * @return String country
     */
    public String getCountry() {
        return country;
    }


    /**
     * @param country String
     */
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * @return String city
     */
    public String getCity() {
        return city;
    }


    /**
     * @param city String
     */
    public void setCity(String city) {
        this.city = city;
    }


    /**
     * @return String eventType
     */
    public String getEventType() {
        return eventType;
    }


    /**
     * @param eventType String
     */
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    /**
     * @return int year
     */
    public int getYear() {
        return year;
    }


    /**
     * @param year int
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * This function is used to see if two event objects are the same
     * @param o Event object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof Event) {
            Event oEvent = (Event) o;
            return oEvent.getEventID().equals(getEventID()) &&
                    oEvent.getUsername().equals(getUsername()) &&
                    oEvent.getPersonID().equals(getPersonID()) &&
                    oEvent.getLatitude() == (getLatitude()) &&
                    oEvent.getLongitude() == (getLongitude()) &&
                    oEvent.getCountry().equals(getCountry()) &&
                    oEvent.getCity().equals(getCity()) &&
                    oEvent.getEventType().equals(getEventType()) &&
                    oEvent.getYear() == (getYear());
        } else {
            return false;
        }
    }
}
