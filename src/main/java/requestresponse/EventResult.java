package requestresponse;

public class EventResult {
    String eventID;
    String associatedUsername;
    String personID;
    float latitude;
    float longitude;
    String country;
    String city;
    String eventType;
    int year;
    String message;
    public boolean success;

    public EventResult(String eventID, String username, String personID, float latitude, float longitude,
                 String country, String city, String eventType, int year, String message, boolean success) {
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
