package itmo.manager;

import java.util.Random;

public class IdGenerator {
    private static Random random = new Random();
    public static Long getId(){
        Long randomNextLong = random.nextLong();
        return (randomNextLong <= 0 ? getId() : randomNextLong);
    }
}
