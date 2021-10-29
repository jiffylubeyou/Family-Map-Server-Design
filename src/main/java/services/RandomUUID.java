package services;

import java.util.UUID;

public class RandomUUID {
    public static String generateRandom()
    {
        return UUID.randomUUID().toString();
    }
}
