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

interface DogFoodFactory {
    fun produceFood(): DogFood
}


    class SmallBreedDogFoodProducer : DogFoodFactory {
        override fun produceFood(): DogFood {
            return SmallBreedDogFood()
        }
    }

    class MediumBreedDogFoodProducer : DogFoodFactory {
        override fun produceFood(): DogFood {
            return MediumBreedDogFood()
        }
    }

    class LargeBreedDogFoodProducer : DogFoodFactory {
        override fun produceFood(): DogFood {
            return LargeBreedDogFood()
        }
    }


    fun main() {
        val smallBreedDogFoodFactory = SmallBreedDogFoodProducer()
        val mediumBreedDogFoodFactory = MediumBreedDogFoodProducer()
        val largeBreedDogFoodFactory = LargeBreedDogFoodProducer()

        val puppySmallBreedDogFood = smallBreedDogFoodFactory.produceFood()
        val puppyMediumBreedDogFood = mediumBreedDogFoodFactory.produceFood()
        val puppyLargeBreedDogFood = largeBreedDogFoodFactory.produceFood()

        puppySmallBreedDogFood.whichFood()
        puppyMediumBreedDogFood.whichFood()
        puppyLargeBreedDogFood.whichFood()
    }

