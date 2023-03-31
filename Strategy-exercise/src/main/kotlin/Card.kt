class Card : PaymentStrategy {
    override fun pay(amount: Double) {
        println("pay with Card. Amount - $amount")
    }
}