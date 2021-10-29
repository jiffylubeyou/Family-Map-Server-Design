package services;

import dao.DataAccessException;
import dao.Database;
import dao.PersonDao;
import model.Person;

import java.sql.Connection;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateGenerations {
    static public void generatePeople(Person person, String lastName, String username, int generations) throws DataAccessException
    {
        String motherID = RandomUUID.generateRandom();
        String fatherID = RandomUUID.generateRandom();

        //generate mom
        Person mother = new Person(motherID, username, getRandomGirlFirstName(), lastName,
                "f", null, null, fatherID);
        //generate dad
        Person father = new Person(fatherID, username, getRandomBoyFirstName(), lastName,
                "m", null, null, motherID);

        person.setMotherID(motherID);
        person.setFatherID(fatherID);

        Database database = new Database();
        Connection conn = database.getConnection();
        PersonDao dao = new PersonDao(conn);
        dao.insert(person);
        database.closeConnection(true);


        if (generations > (0))
        {
            generations = generations - 1;
            GenerateGenerations.generatePeople(mother, getRandomLastName(), username, generations);
            GenerateGenerations.generatePeople(father, lastName, username, generations);
        }
    }

    static private String getRandomGirlFirstName()
    {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        if (randomNum == 0)
        {
            return "Sally";
        }
        if (randomNum == 1)
        {
            return "Lucy";
        }
        if (randomNum == 2)
        {
            return "Olga";
        }
        if (randomNum == 3)
        {
            return "Leshanda";
        }
        if (randomNum == 4)
        {
            return "Rhonda";
        }
        if (randomNum == 5)
        {
            return "Susan";
        }
        if (randomNum == 6)
        {
            return "Samantha";
        }
        if (randomNum == 7)
        {
            return "Scarlet";
        }
        if (randomNum == 8)
        {
            return "Evangeline";
        }
        if (randomNum == 9)
        {
            return "Elizabeth";
        }
        return "This shouldn't happen";
    }

    static private String getRandomBoyFirstName() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        if (randomNum == 0) {
            return "Bill";
        }
        if (randomNum == 1) {
            return "Bob";
        }
        if (randomNum == 2) {
            return "Frank";
        }
        if (randomNum == 3) {
            return "Rob";
        }
        if (randomNum == 4) {
            return "Joe";
        }
        if (randomNum == 5) {
            return "Peter";
        }
        if (randomNum == 6) {
            return "Bruce";
        }
        if (randomNum == 7) {
            return "Max";
        }
        if (randomNum == 8) {
            return "Kenny";
        }
        if (randomNum == 9) {
            return "Alex";
        }
        return "This shouldn't happen";
    }

    static private String getRandomLastName() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 9 + 1);
        if (randomNum == 0) {
            return "Johansson";
        }
        if (randomNum == 1) {
            return "Strong";
        }
        if (randomNum == 2) {
            return "Lee";
        }
        if (randomNum == 3) {
            return "Amado-Vo";
        }
        if (randomNum == 4) {
            return "Smith";
        }
        if (randomNum == 5) {
            return "Brown";
        }
        if (randomNum == 6) {
            return "White";
        }
        if (randomNum == 7) {
            return "Black";
        }
        if (randomNum == 8) {
            return "Wayne";
        }
        if (randomNum == 9) {
            return "Grundy";
        }
        return "This shouldn't happen";
    }
}
