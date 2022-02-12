package requestresponse;

public class EventResult {
    String eventID;
    String associatedUsername;
    String personID;
    String latitude;
    String longitude;
    String country;
    String city;
    String eventType;
    String year;
    String message;
    public boolean success;

    /**
     * Constructor that takes in the object necessary to build the object
     * @param eventID
     * @param username
     * @param personID
     * @param latitude
     * @param longitude
     * @param country
     * @param city
     * @param eventType
     * @param year
     * @param message
     * @param success
     */
    public EventResult(String eventID, String username, String personID, String latitude, String longitude,
                 String country, String city, String eventType, String year, String message, boolean success) {
        this.eventID = eventID;
        this.associatedUsername = username;
        this.personID = personID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.city = city;
        this.eventType = eventType;
        this.year = year;
        this.message = message;
        this.success = success;
    }
}
