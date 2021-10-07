package services;

import requestresponse.PersonRequest;
import requestresponse.PersonResult;

public class Person {
    private PersonRequest personRequest;

    /**
     * takes int person ID
     * @param personRequest PersonRequest object
     */
    public Person (PersonRequest personRequest)
    {
        this.personRequest = personRequest;
    }

    /**
     * gives back the person info from the ID given
     * @return PersonResult object
     */
    PersonResult processPerson () {
        return new PersonResult();
    }
}
