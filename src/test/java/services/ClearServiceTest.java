package services;

import org.junit.jupiter.api.*;
import requestresponse.ClearResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClearServiceTest {

    @BeforeEach
    public void setUp() {}

    @AfterEach
    public void tearDown() {}

    @Test
    public void clearPass()
    {
        ClearResult compareTest = new ClearResult("Clear succeeded", true);
        ClearService service = new ClearService();
        ClearResult result = service.processClear();
        assertEquals(result.success, compareTest.success);
    }
}
