class WeatherSubject : Subject {

    private val observers = mutableListOf<Observer>()
    private lateinit var state: Weather

    fun setState(state: Weather) {
        this.state = state
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
        println("$observer added!")
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
        println("$observer removed!")
    }

    override fun notifyObservers() {
        observers.forEach { it.updateWeather(state) }
    }
}