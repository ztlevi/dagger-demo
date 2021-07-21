package example.dagger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoffeeAppTest {
    @Test
    void testCoffeeApp() {
        CoffeeApp app = new CoffeeApp();
        app.maker.brew();
        app.logger.logs().forEach(log -> System.out.println(log));
    }
}
