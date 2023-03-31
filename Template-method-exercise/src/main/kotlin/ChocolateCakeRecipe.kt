class ChocolateCakeRecipe : Cake() {
    override fun prepareIngredients() {
        println("preparing ingredients for the chocolate cake")
    }

    override fun mixIngredients() {
        println("mixing chocolate cake ingredients")
    }

    override fun bake() {
        println("Baking chocolate cake for 30 minutes at 180 degrees Celsius")
    }

    override fun decorate() {
        println("decorating chocolate cake")
    }
}