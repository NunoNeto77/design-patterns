/*
The 'Observer' pattern plays an important role in Android app development, particularly when an
MVVM (Model-View-ViewModel) architecture is used.

A very common situation is having the UI (the 'View') observing and reacting to changes in a state variable
held by the ViewModel. Here's an example: a weather app displays an image representing the current weather
conditions at all times. Whenever these weather conditions change, the app is notified by an external service
and reacts accordingly. A typical architecture for this app would be:

         View                        ViewModel                                             Model
    (UI, stateless)   <---->   (holds the UI state)   <---->   (communicates with external services, third-party apps, etc.)

Let's focus on the View-ViewModel pair. Starting with the code snippet below, implement the necessary modifications for
'WeatherView' to react to changes in the 'weather' state held by 'WeatherViewModel'.

Note that the function 'updateWeather' of 'WeatherView' is used here only for testing purposes, you shouldn't modify it.
In a real scenario, the 'View' would never update the 'weather' state directly.
 */

fun main() {

    val subject = WeatherSubject()

    val observer1 = WeatherObserver("Observer 1")
    val observer2 = WeatherObserver("Observer 2")
    val observer3 = WeatherObserver("Observer 3")

    subject.registerObserver(observer1)
    subject.registerObserver(observer2)
    subject.registerObserver(observer3)

    Thread.sleep(2000L)
    subject.setState(Weather.CLOUDY)

    subject.removeObserver(observer2)

    Thread.sleep(3000L)
    subject.setState(Weather.RAIN)

}

