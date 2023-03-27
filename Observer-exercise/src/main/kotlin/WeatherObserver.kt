class WeatherObserver(private val name: String) : Observer {
    override fun updateWeather(weather: Weather) {
        println("$name received message: $weather")
    }
}