package services;

import requestresponse.PersonArrayResult;

public class PersonArrayService {

    /**
     * Will give us an array of all the people in the person table
     * @return PersonArrayResult object
     */
    PersonArrayResult processPersonArray () {
        return new PersonArrayResult();
    }
}
