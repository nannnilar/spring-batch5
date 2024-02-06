package demo;

public class ChicagoPizza extends PizzaTemplate{
    @Override
    public void prepared() {
        System.out.println("Chaicago pizza prepared.");
    }

    @Override
    public void topping() {
        System.out.println("Chaicago pizza topping.");
    }

    @Override
    public void baked() {
        System.out.println("Chaicago pizza baked.");
    }

    @Override
    public void serve() {
        System.out.println("Chaicago pizza serve.");
    }
}
