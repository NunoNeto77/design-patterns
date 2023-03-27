 abstract class PizzaDecorator(private val pizza: Pizza) : Pizza {
     override fun makePizza(): String {
         return pizza.makePizza()
     }

     override fun getPrice(): Double {
        return pizza.getPrice()
     }
 }