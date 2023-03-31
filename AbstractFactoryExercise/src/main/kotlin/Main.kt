enum class BreedSize {
    SMALL, MEDIUM, LARGE
}

interface SmallBreedDogFood {
    fun whichFood()
}

interface MediumBreedDogFood {
    fun whichFood()
}

interface LargeBreedDogFood {
    fun whichFood()
}


class SmallBreedDogFoodImpl : SmallBreedDogFood {
    override fun whichFood(){
        println("Food for small breed dog type")
    }
}

class MediumBreedDogFoodImpl : MediumBreedDogFood {
    override fun whichFood(){
        println("Food for medium breed dog type")
    }
}


class LargeBreedDogFoodImpl : LargeBreedDogFood {
    override fun whichFood(){
        println("Food for large breed dog type")
    }
}


class SmallBreedDogFoodFactory : DogFoodFactory {
    override fun createSmallBreedDogFood(): SmallBreedDogFood {
        return SmallBreedDogFoodImpl()
    }

    override fun createMediumBreedDogFood(): MediumBreedDogFood {
        return MediumBreedDogFoodImpl()
    }

    override fun createLargeBreedDogFood(): LargeBreedDogFood {
        return LargeBreedDogFoodImpl()
    }

}

class MediumBreedDogFoodFactory : DogFoodFactory {
    override fun createSmallBreedDogFood(): SmallBreedDogFood {
        return SmallBreedDogFoodImpl()
    }

    override fun createMediumBreedDogFood(): MediumBreedDogFood {
        return MediumBreedDogFoodImpl()
    }

    override fun createLargeBreedDogFood(): LargeBreedDogFood {
        return LargeBreedDogFoodImpl()
    }
}

class LargeBreedDogFoodFactory : DogFoodFactory {
    override fun createSmallBreedDogFood(): SmallBreedDogFood {
        return SmallBreedDogFoodImpl()
    }

    override fun createMediumBreedDogFood(): MediumBreedDogFood {
        return MediumBreedDogFoodImpl()
    }

    override fun createLargeBreedDogFood(): LargeBreedDogFood {
        return LargeBreedDogFoodImpl()
    }

}




fun main() {
    val smallBreedDogFoodFactory = SmallBreedDogFoodFactory()
    val mediumBreedDogFoodFactory = MediumBreedDogFoodFactory()
    val largeBreedDogFoodFactory = LargeBreedDogFoodFactory()

    val puppySmallBreedDogFood = smallBreedDogFoodFactory.createSmallBreedDogFood()
    val puppyMediumBreedDogFood = mediumBreedDogFoodFactory.createMediumBreedDogFood()
    val puppyLargeBreedDogFood = largeBreedDogFoodFactory.createLargeBreedDogFood()

    puppySmallBreedDogFood.whichFood()
    puppyMediumBreedDogFood.whichFood()
    puppyLargeBreedDogFood.whichFood()
}