package Learn.Pattern.Builder;

import Learn.Pattern.Builder.Builders.Director;
import Learn.Pattern.Builder.Builders.PizzaBuilder;
import Learn.Pattern.Builder.Builders.PizzaManualBuilder;
import Learn.Pattern.Builder.Components.Cheese;
import Learn.Pattern.Builder.Components.Meat;
import Learn.Pattern.Builder.Components.Vegetables;

public class Main {
    public static void main(String[] args) {

        PizzaBuilder builder = new PizzaBuilder();
        Director director = new Director();

        director.constructSeaPizza(builder);
        Pizza seaPizza = builder.getResult();
        System.out.println("Your order is sea pizza: " + seaPizza);

        director.constructMeatPizza(builder);
        Pizza meatPizza = builder.getResult();
        System.out.println("Your order is meat pizza: " + meatPizza);

        ManualPizza meatCheesyHotPizza;
        PizzaManualBuilder manualBuilder = new PizzaManualBuilder();
        director.constructMeatPizza(manualBuilder);
        manualBuilder.addCheese(Cheese.PARMESAN, Cheese.SMETANKOVIY);
        manualBuilder.addVegetables(Vegetables.CHILI_PEPPER, Vegetables.JALAPENO);
        manualBuilder.addMeat(Meat.PROSHUTTO);
        meatCheesyHotPizza = manualBuilder.getResult();
        System.out.println("Your order: " + meatCheesyHotPizza);

    }

}
