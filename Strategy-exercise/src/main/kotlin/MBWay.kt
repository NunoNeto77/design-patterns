class MBWay : PaymentStrategy {
    override fun pay(amount: Double) {
        println("pay with MB Way. Amount - $amount")
    }
}