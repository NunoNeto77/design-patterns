class SimplePizza : Pizza {
    override fun makePizza(): String {
        return "here is your pizza"
    }

    override fun getPrice(): Double {
        return 10.0
    }
}