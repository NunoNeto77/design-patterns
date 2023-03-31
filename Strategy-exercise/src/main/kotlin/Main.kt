// Using ShoppingCart as our Context, implement the strategy design pattern using two different payment strategies (MBWay and Card)

fun main() {
    val paymentMethod = ShoppingCart(MBWay())
    val amount = 42.4

    paymentMethod.checkout(amount)

    paymentMethod.setStrategy(Card())
    paymentMethod.checkout(amount)
}
