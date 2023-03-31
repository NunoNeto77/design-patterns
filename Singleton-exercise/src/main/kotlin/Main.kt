
/*
Functions that rely on singletons to do certain tasks can sometimes be hard to test. In fact, that is a commonly cited disadvantage of using that design pattern.

Take a look at the example below. We would like to test the 'functionUnderTest', but that functions calls "doSomething" provided by "Singleton" and the latter performs some
task that usually fails in a testing context (e.g., accessing a remote database or the lower layers of an SW stack). The problem arises because singletons are hard to mock (though
some testing frameworks do allow you to mock singleton objects).

Can you modify the code below in a way that
(1) allows one to test 'functionUnderTest' and, at the same time,
(2) doesn't compromise the way 'Singleton' is meant to work in a production environment?
 */

class SingletonImpl private constructor() : Singleton {

    // Singleton function that does something that might fail during testing (e.g., accessing a remote database)
    override fun doSomething(): Int {
        println("### FAILS IN A TESTING ENVIRONMENT ###")  // Might even cause a crash!
        val unexpectedResult = -1
        return unexpectedResult
    }

    companion object {

        private var instance: Singleton? = null

        @Synchronized
        fun getInstance(): Singleton {
            if(instance == null) instance = SingletonImpl()
            return instance!!
        }
    }
}

class SingletonUser(private val singleton: Singleton) {

    fun functionUnderTest() {
        // ... Other function logic ...
        val result = singleton.doSomething()
        // Logic that does something with 'result'
    }

}

fun singletonTest() {
    println("Initializing test...")
    val user = SingletonUser(SingletonTestImpl(1))
    user.functionUnderTest()
}


fun main() {
    singletonTest()
}
