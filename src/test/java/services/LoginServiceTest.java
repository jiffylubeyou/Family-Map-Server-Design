package services;

import model.Event;
import model.Person;
import model.User;
import org.junit.jupiter.api.*;
import requestresponse.*;

import static org.junit.jupiter.api.Assertions.*;

public class LoginServiceTest {

    @BeforeEach
    public void setUp()
    {
        LoadRequest request = new LoadRequest();
        request.users = new User[] {
                new User("lilJim", "butter", "jimdum@cs.byu.edu", "Jimmy", "DumDum",
                        "m", "1234"),
                new User("TheBigOlg", "jelly", "Olgsmash@cs.byu.edu", "Olga", "Smash",
                        "f", "5678")
        };
        request.persons = new Person[] {
                new Person("1234", "lilJim", "Jimmy", "DumDum", "m",
                        "12", "34", null),
                new Person("5678", "TheBigOlg", "Olga", "Smash", "f",
                        "56", "78", null)
        };
        request.events = new Event[] {
                new Event("4321", "lilJim", "1234", 1, 2, "China",
                        "Smallville", "Tripped", 5),
                new Event("8765", "TheBigOlg", "5678", 3, 4, "SovietUnion",
                        "Gotham", "Incarcerated", 10)
        };
        LoadService service = new LoadService(request);
        service.processLoad();

    }

    @AfterEach
    public void tearDown()
    {
        ClearService service = new ClearService();
        service.processClear();
    }

    @Test
    public void loginPass()
    {
        LoginRequest request = new LoginRequest();
        request.setDataFromRegister("lilJim", "butter");
        LoginService service   = new LoginService(request);
        LoginResult result = service.processLogin();
        assertTrue(result.success);
    }

    @Test
    public void loginFail()
    {
        LoginRequest request = new LoginRequest();
        request.setDataFromRegister("lilJim", "jelly");
        LoginService service   = new LoginService(request);
        LoginResult result = service.processLogin();
        assertFalse(result.success);
    }
}
