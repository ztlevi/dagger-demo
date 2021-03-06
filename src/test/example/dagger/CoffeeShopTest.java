package example.dagger;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CoffeeShopTest {
    @Test
    void testCoffeeShopWithFunctions() {
        CoffeeShopComponent coffeeShop = DaggerCoffeeShopComponent.builder().build();
        coffeeShop.maker().brew();
        coffeeShop.logger().logs().forEach(log -> System.out.println(log));
    }

    @Test
    void testInlineCoffeeShop() {
        CoffeeApp.InlineCoffeeShop inlineCoffeeShop = DaggerCoffeeApp_InlineCoffeeShop.builder().build();
        inlineCoffeeShop.maker().brew();
        inlineCoffeeShop.logger().logs().forEach(log -> System.out.println(log));
    }
}
