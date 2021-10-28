package services;

import requestresponse.PersonRequest;
import requestresponse.PersonResult;

public class PersonService {
    private PersonRequest personRequest;

    /**
     * takes int person ID
     * @param personRequest PersonRequest object
     */
    public PersonService (PersonRequest personRequest)
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
