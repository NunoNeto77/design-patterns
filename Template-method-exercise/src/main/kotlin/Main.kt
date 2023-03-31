// Implement the template method design pattern using the recipe for cook a cake as the algorithm to bake Chocolate or
// Vanilla cakes. The steps of the algorithm should be prepareIngredients(), mixIngredients(), bake(), cool() and decorate().
// Cool() should be common to the two recipes.

fun main() {
    println("Baking a chocolate cake")
    val chocolateCakeRecipe = ChocolateCakeRecipe()
    chocolateCakeRecipe.bakeCake()
    println()

    println("Baking a vanilla cake")
    val vanillaCakeRecipe = VanillaCakeRecipe()
    vanillaCakeRecipe.bakeCake()
}
