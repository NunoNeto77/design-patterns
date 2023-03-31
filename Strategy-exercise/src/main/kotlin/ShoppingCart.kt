// Context
class ShoppingCart(private var strategy: PaymentStrategy) {
    fun checkout(amount: Double) {
        strategy.pay(amount)
    }

    fun setStrategy(strategy: PaymentStrategy) {
        this.strategy = strategy
    }
}