abstract class Cake {

     fun bakeCake() {
        prepareIngredients()
        mixIngredients()
        bake()
        cool()
        decorate()
    }

    abstract fun prepareIngredients()
    abstract fun mixIngredients()
    abstract fun bake()

    fun cool() {
        println("the cake is cooling")
    }

    abstract fun decorate()
}