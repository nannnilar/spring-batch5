package demo;

public abstract class PizzaTemplate {

    public final void makePizza(){
        prepared();
        topping();
        baked();
        serve();
    }

    public abstract void prepared();
    public abstract void topping();
    public abstract void baked();
    public abstract void serve();
}
