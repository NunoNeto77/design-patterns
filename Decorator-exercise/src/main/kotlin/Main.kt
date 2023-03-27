fun main(args: Array<String>) {

    val simplePizza = SimplePizza()
    println(simplePizza.makePizza())
    println("it costs " + simplePizza.getPrice() + " dollars")
    println()

    val pizzaWithPepperoni = Pepperoni(simplePizza)
    println(pizzaWithPepperoni.makePizza())
    println("it costs " + pizzaWithPepperoni.getPrice() + " dollars")
    println()

    val pizzaWithMoreCheese = MoreCheese(simplePizza)
    println(pizzaWithMoreCheese.makePizza())
    println("it costs " + pizzaWithMoreCheese.getPrice() + " dollars")
    println()

    val pizzaWithPineapple = Pineapple(simplePizza)
    println(pizzaWithPineapple.makePizza())
    println("it costs " + pizzaWithPineapple.getPrice() + " dollars")
}