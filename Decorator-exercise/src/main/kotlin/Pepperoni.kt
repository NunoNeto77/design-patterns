// using composition
class Pepperoni(pizza: Pizza) : PizzaDecorator(pizza) {

    override fun makePizza(): String {
        return super.makePizza() + " with pepperoni"
    }

    override fun getPrice(): Double {
        return super.getPrice() + 2
    }
}
