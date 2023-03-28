package observerNativeSolution

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

enum class Weather {
    CLEAR,
    CLOUDY,
    RAIN,
    FOG
}

class WeatherViewModel {

    /*
    Both Kotlin flows (https://developer.android.com/kotlin/flow/stateflow-and-sharedflow) and Android Jetpack LiveData
    (https://developer.android.com/topic/libraries/architecture/livedata) implement the 'Observer' pattern out of the box
    in Android, so if you're working on an app consider using one of them instead of creating your own solution -
    no need to "reinvent the wheel".

    Kotlin flows in particular implement the pattern in a highly customizable manner, allowing one to create solutions that
    are tailored to address specific needs and use cases. For more info, see https://developer.android.com/kotlin/flow
    */
    private val _weather = MutableStateFlow(Weather.CLEAR)
    val weather = _weather.asStateFlow()

    // Function used by the 'Model' to update the weather
    fun updateWeather(weather: Weather) {
        this._weather.value = weather
    }
}

@OptIn(DelicateCoroutinesApi::class)
class WeatherView() {

    private val viewModel = WeatherViewModel()

    init {
        println("Initializing 'WeatherView'")
        GlobalScope.launch {
            viewModel.weather.collect { // collect = subscribe/addObserver
                println("Weather changed: $it")
                // Do something like updating the UI based on the new weather value
            }
        }
    }

    // JUST FOR TESTING PURPOSES: in a real scenario, the 'View' would never update the 'weather' variable
    fun updateWeather(weather: Weather) {
        viewModel.updateWeather(weather)
    }
}

fun main() {
    val view = WeatherView()

    Thread.sleep(2000L)
    view.updateWeather(Weather.FOG)

    Thread.sleep(3000L)
    view.updateWeather(Weather.CLEAR)

    Thread.sleep(3000L)
    view.updateWeather(Weather.RAIN)
}

/*
This code needs to be compiled against the kotlinx-coroutines packages, which are packed inside the kotlinx-coroutines-core library.
You'll need first to download the kotlinx-coroutines-core-jvm-<version>.jar from https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core-jvm
(it works with version 1.6.4) and then compile using the command

kotlinc -classpath <path_to_kotlinx-coroutines-core_lib> -include-runtime -d <output_JAR_filename> <input_KT_filename>
(e.g., kotlinc -classpath ./kotlinx-coroutines-core-jvm-1.6.4.jar -include-runtime -d solution.jar observerSolutionNative.kt)

To run the resulting JAR
java -classpath <output_JAR_filename>:<path_to_kotlinx-coroutines-core_lib> <input_KT_filename_PascalCase>
(e.g., java -classpath solution.jar:kotlinx-coroutines-core-jvm-1.6.4.jar ObserverSolutionNativeKt)
 */
 
