package services;

import dao.DataAccessException;
import dao.Database;
import dao.EventDao;
import dao.PersonDao;
import handler.GsonSerializer;
import model.Event;
import model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateGenerations {
    static public void generatePeople(Person person, String lastName, String username, int year, int generations) throws DataAccessException, IOException
    {
        String motherID = RandomUUID.generateRandom();
        String fatherID = RandomUUID.generateRandom();

        //generate mom
        Person mother = new Person(motherID, username, getRandomGirlFirstName(), lastName,
                "f", null, null, fatherID);
        //generate dad
        Person father = new Person(fatherID, username, getRandomBoyFirstName(), lastName,
                "m", null, null, motherID);

        if (generations > 0) {
            person.setMotherID(motherID);
            person.setFatherID(fatherID);
        }

        Database database = new Database();
        try {
            Connection conn = database.getConnection();
            EventDao eventDao = new EventDao(conn);

            //Add events
            Location birthLocation = getRandomLocation();
            Event birth = new Event(RandomUUID.generateRandom(), person.getAssociatedUsername(), person.getPersonID(),
                    birthLocation.latitude, birthLocation.longitude, birthLocation.country, birthLocation.city,
                    "birth", (year - 20));
            eventDao.insert(birth);

            if (generations > 0) {
                Location marriageLocation = getRandomLocation();
                Event marriageMom = new Event(RandomUUID.generateRandom(), person.getAssociatedUsername(), motherID,
                        marriageLocation.latitude, marriageLocation.longitude, marriageLocation.country, marriageLocation.city,
                        "marriage", (year - 30));

                Event marriageDad = new Event(RandomUUID.generateRandom(), person.getAssociatedUsername(), fatherID,
                        marriageLocation.latitude, marriageLocation.longitude, marriageLocation.country, marriageLocation.city,
                        "marriage", (year - 30));
                eventDao.insert(marriageMom);
                eventDao.insert(marriageDad);
            }

            if (person.getSpouseID() != null) {
                Location deathLocation = getRandomLocation();
                Event death = new Event(RandomUUID.generateRandom(), person.getAssociatedUsername(), person.getPersonID(),
                        deathLocation.latitude, deathLocation.longitude, deathLocation.country, deathLocation.city,
                        "death", (year + 20));
                eventDao.insert(death);
            }
            database.closeConnection(true);

            Connection conn2 = database.getConnection();
            PersonDao dao = new PersonDao(conn2);
            dao.insert(person);
            database.closeConnection(true);
        }
        catch (DataAccessException e)
        {
            try {
                database.closeConnection(false);
            }
            catch (DataAccessException ex)
            {
                throw ex;
            }
            throw e;
        }

        if (generations > (0))
        {
            year = year - 30;
            generations = generations - 1;
            GenerateGenerations.generatePeople(mother, getRandomLastName(), username, year, generations);
            GenerateGenerations.generatePeople(father, lastName, username, year, generations);
        }
    }

    static private String getRandomGirlFirstName() throws IOException
    {
        Path fileName = Path.of("./json/fnames.json");
        String string = Files.readString(fileName);
        DataArray fnames = GsonSerializer.fromJson(string, DataArray.class);
        int randomNum = ThreadLocalRandom.current().nextInt(0, fnames.data.length);
        return fnames.data[randomNum];
    }

    static private String getRandomBoyFirstName() throws  IOException
    {
        Path fileName = Path.of("./json/mnames.json");
        String string = Files.readString(fileName);
        DataArray mnames = GsonSerializer.fromJson(string, DataArray.class);
        int randomNum = ThreadLocalRandom.current().nextInt(0, mnames.data.length);
        return mnames.data[randomNum];
    }

    static private String getRandomLastName() throws IOException
    {
        Path fileName = Path.of("./json/snames.json");
        String string = Files.readString(fileName);
        DataArray snames = GsonSerializer.fromJson(string, DataArray.class);
        int randomNum = ThreadLocalRandom.current().nextInt(0, snames.data.length);
        return snames.data[randomNum];
    }

    static private Location getRandomLocation() throws IOException
    {
        Path fileName = Path.of("./json/locations.json");
        String string = Files.readString(fileName);
        LocationArray locations = GsonSerializer.fromJson(string, LocationArray.class);
        int randomNum = ThreadLocalRandom.current().nextInt(0, locations.data.length);
        return locations.data[randomNum];
    }
}
