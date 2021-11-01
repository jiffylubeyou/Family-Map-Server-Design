package services;

import org.junit.jupiter.api.*;
import requestresponse.*;

import static org.junit.jupiter.api.Assertions.*;

public class RegisterServiceTest {

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown()
    {
        ClearService service = new ClearService();
        service.processClear();
    }

    @Test
    public void registerPass()
    {
        RegisterRequest request = new RegisterRequest();
        request.username = "lilJim";
        request.password = "butter";
        request.email = "jimdum@cs.byu.edu";
        request.firstName = "Jimmy";
        request.lastName = "DumDum";
        request.gender = "m";
        RegisterService service   = new RegisterService(request);
        RegisterResult result = service.processRegister();
        assertTrue(result.success);
    }

    @Test
    public void registerFail()
    {
        RegisterRequest request = new RegisterRequest();
        request.username = "lilJim";
        request.password = "butter";
        request.email = "jimdum@cs.byu.edu";
        request.firstName = "Jimmy";
        request.lastName = "DumDum";
        request.gender = "m";
        RegisterService service   = new RegisterService(request);
        service.processRegister();

        RegisterRequest request2 = new RegisterRequest();
        request.username = "lilJim";
        request.password = "butter";
        request.email = "jimdum@cs.byu.edu";
        request.firstName = "Jimmy";
        request.lastName = "DumDum";
        request.gender = "m";
        RegisterService service2   = new RegisterService(request2);
        RegisterResult result2 = service2.processRegister();
        assertFalse(result2.success);
    }
}
