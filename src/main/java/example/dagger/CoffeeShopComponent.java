package example.dagger;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {HeaterModule.class, PumpModule.class})
public interface CoffeeShopComponent {
    void inject(CoffeeApp coffeeApp);
    CoffeeMaker maker();
    CoffeeLogger logger();
}
