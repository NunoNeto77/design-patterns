class VanillaCakeRecipe : Cake() {
    override fun prepareIngredients() {
        println("preparing ingredients for the vanilla cake")
    }

    override fun mixIngredients() {
        println("mixing vanilla cake ingredients")
    }

    override fun bake() {
        println("Baking vanilla cake for 25 minutes at 180 degrees Celsius")
    }

    override fun decorate() {
        println("decorating vanilla cake")
    }
}