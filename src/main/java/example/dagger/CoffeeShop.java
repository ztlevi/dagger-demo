package example.dagger;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {HeaterModule.class, PumpModule.class})
public interface CoffeeShop {
    CoffeeMaker maker();
    CoffeeLogger logger();
}
