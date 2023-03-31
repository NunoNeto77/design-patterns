enum class BreedSize {
    SMALL, MEDIUM, LARGE
}

interface DogFood {
    fun whichFood()
}

class SmallBreedDogFood : DogFood {
    override fun whichFood(){
        println("Food for small breed dog type")
    }
}

class MediumBreedDogFood : DogFood {
    override fun whichFood(){
        println("Food for medium breed dog type")
    }
}


class LargeBreedDogFood : DogFood {
    override fun whichFood(){
        println("Food for large breed dog type")
    }
}


class DogFoodFactory {
    fun produceFood(breedSize: BreedSize) : DogFood {
        return when(breedSize) {
            BreedSize.SMALL -> SmallBreedDogFood()
            BreedSize.MEDIUM -> MediumBreedDogFood()
            BreedSize.LARGE -> LargeBreedDogFood()
        }
    }
}



fun main() {
    val dogFoodFactory : DogFoodFactory = DogFoodFactory()

    val puppySmallBreedDogFood : DogFood = dogFoodFactory.produceFood(BreedSize.SMALL)
    val puppyMediumBreedDogFood : DogFood = dogFoodFactory.produceFood(BreedSize.MEDIUM)
    val puppyLargeBreedDogFood: DogFood = dogFoodFactory.produceFood(BreedSize.LARGE)

    puppySmallBreedDogFood.whichFood()
    puppyMediumBreedDogFood.whichFood()
    puppyLargeBreedDogFood.whichFood()
}
