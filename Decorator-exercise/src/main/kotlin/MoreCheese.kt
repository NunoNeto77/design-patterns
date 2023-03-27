// using composition
class MoreCheese(pizza: Pizza) : PizzaDecorator(pizza) {

    override fun makePizza(): String {
        return super.makePizza() + " with more cheese"
    }

    override fun getPrice(): Double {
        return super.getPrice() + 1
    }
}