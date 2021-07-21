/*
 * Copyright (C) 2020 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package example.dagger;

import dagger.Component;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * The main app responsible for brewing the coffee and printing the logs.
 */
public class CoffeeApp {
    CoffeeShopComponent coffeeShop;

    @Inject CoffeeLogger logger;
    @Inject CoffeeMaker maker;

    CoffeeApp() {
        coffeeShop = DaggerCoffeeShopComponent.create();
        // Or coffeeShop = DaggerCoffeeShopComponent.builder().build();
        coffeeShop.inject(this);
    }

    @Singleton
    @Component(modules = {HeaterModule.class, PumpModule.class})
    public interface InlineCoffeeShop {
        CoffeeMaker maker();
        CoffeeLogger logger();
    }

    public static void main(String[] args) {
        System.out.println("=========== Test separate interface CoffeeShop ==========");
        CoffeeShopComponent coffeeShop = DaggerCoffeeShopComponent.builder().build();
        coffeeShop.maker().brew();
        coffeeShop.logger().logs().forEach(log -> System.out.println(log));

        System.out.println("========== Test inline CoffeeShop interface ============");
        InlineCoffeeShop inlineCoffeeShop = DaggerCoffeeApp_InlineCoffeeShop.builder().build();
        inlineCoffeeShop.maker().brew();
        inlineCoffeeShop.logger().logs().forEach(log -> System.out.println(log));
    }
}
