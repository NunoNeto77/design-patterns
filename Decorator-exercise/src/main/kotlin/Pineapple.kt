// using delegation
class Pineapple(private val pizza: Pizza) : Pizza by pizza {

    override fun makePizza(): String {
        return pizza.makePizza() + addPineapple()
    }

    override fun getPrice(): Double {
        return pizza.getPrice() + 1.5
    }

    private fun addPineapple(): String {
        return " with pineapple"
    }
}