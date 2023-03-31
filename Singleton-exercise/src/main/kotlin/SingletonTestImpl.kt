class SingletonTestImpl(val resultToReturn: Int) : Singleton {
    override fun doSomething(): Int {
        println("Mocks doSomething: result=$resultToReturn")
        return resultToReturn
    }

}