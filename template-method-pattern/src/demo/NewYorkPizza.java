package demo;

public class NewYorkPizza extends PizzaTemplate{
    @Override
    public void prepared() {
        System.out.println("NewYork pizza prepared.");
    }

    @Override
    public void topping() {
        System.out.println("NewYork pizza topping.");
    }

    @Override
    public void baked() {
        System.out.println("NewYork pizza baked.");
    }

    @Override
    public void serve() {
        System.out.println("NewYork pizza served.");
    }
}
