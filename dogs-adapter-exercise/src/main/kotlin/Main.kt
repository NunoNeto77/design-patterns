class RobotDog {
    fun makeNoise() {
        println("Bip Bip")
    }
}

class RealDog : Dog {
    override fun bark() {
        println("Wof Wof")
    }
}

class DogAdapter() : Dog {
    override fun bark() {
        val robotDog = RobotDog()
        robotDog.makeNoise()
    }

}

fun processDog(dog : Dog) {
    dog.bark()
}

fun main() {
    val realDog = RealDog()
    val robotDog = DogAdapter()

    processDog(realDog)
    processDog(robotDog)

}





// Another solution - to make the robotDog do the realDog's sound

/*class RobotDog : SoundMaker {

    private val dogAdapter = DogAdapter(RealDog())

    fun makeNoise() {
        println("Bip Bip")
    }

    override fun makeSound() {
        return dogAdapter.makeSound()
    }
}

class RealDog : SoundMaker {
    override fun makeSound() {
        println("Wof Wof")
    }
}

class DogAdapter(private var realDog: RealDog) : SoundMaker {

    override fun makeSound() {
        return realDog.makeSound()
    }
}


fun main() {

    val realDog = RealDog()
    val robotDog = RobotDog()

    println(realDog.makeSound())
    println(robotDog.makeSound())
} */
