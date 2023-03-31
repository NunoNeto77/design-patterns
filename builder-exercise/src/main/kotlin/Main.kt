/*
Many objects in Android are configured and created using 'Builders'. An example is 'AudioAttributes'
(https://android.googlesource.com/platform/frameworks/base/+/master/media/java/android/media/AudioAttributes.java)
but there are others. In many cases, this configuration goes beyond setting the values of variables: listeners
and actions to be performed under certain circumstances are also prescribed.

Here, we'll implement a basic version of a 'MediaItem' object (for the sake of simplicity, we'll assume that 'media' means
'song' in this context). Our 'MediaItem' can have up to 4 attributes:
    - Name (mandatory)
    - Artist (mandatory)
    - Album (optional)
    - Duration in seconds (optional)

Although in this case it wouldn't be too difficult to create 'MediaItem's directly (i.e., without a builder), our expectation
is that in the future the number of optional attributes of 'MediaItem' will grow substantially, so implementing a builder
is a good way to future-proof the code.

You have two tasks:
1) implement a builder that can be used to configure and create 'MediaItem's. Remember that 'name' and 'artist' are mandatory attributes!
2) sometimes, we might want to do something before the 'MediaItem' starts playing. For example, set the volume to 100% or set the
background of our player's UI to yellow. Moreover, every 'MediaItem' can potentially have a different "beforePlaying" action: if you're
playing a Metallica song you may want to adjust the bass and loudness, if you're playing a Katy Perry song you might consider adding a
glittering effect to the player's UI, and so on. Can you find a way to implement this feature?
 */

class MediaItem private constructor(
    private val name: String,
    private val artist: String,
    private val album: String?,
    private val durationInSec: Long?,
    private val beforePlaying: () -> Unit
)

{

    fun play() {

        println("***\nPlaying MediaItem\n***")
        println("Name: $name")
        println("Artist: $artist")
        album?.let{ println("Album: $it") }
        durationInSec?.let { println("Duration: ${it}s") }

        // Part 2: perform "beforePlaying" action here
        beforePlaying()

        // Start playing the 'MediaItem'...
    }

    class Builder(private var name: String, private var artist: String) {
        private var album: String? = ""
        private var durationInSec: Long? = 0
        private var beforePlaying: () -> Unit = {}

        fun album(album: String) = apply { this.album = album }
        fun durationInSec(durationInSec: Long) = apply { this.durationInSec = durationInSec }
        fun beforePlaying(beforePlaying: () -> Unit) = apply { this.beforePlaying = beforePlaying}

        fun build() = MediaItem(
            name = name,
            artist = artist,
            album = album,
            durationInSec = durationInSec,
            beforePlaying = beforePlaying
        )

    }


}

class VolumeController {
    fun setVolume(volume: Int) {
        println("--- Setting volume to $volume")
    }
}

class BackgroundController {
    fun setBackgroundColor(color: String) {
        println("--- Setting background color to $color")
    }
}

fun main() {

    val mediaItem0 = MediaItem.Builder("I Am Mine", "Pearl Jam")
        .album("Riot Act")
        .durationInSec(215L)
        .beforePlaying { VolumeController().setVolume(100) }
        .build()

    mediaItem0.play()

    Thread.sleep(3000L)
    println("")

    val mediaItem1 = MediaItem.Builder("Poker Face", "Lady Gaga")
        .beforePlaying { BackgroundController().setBackgroundColor("yellow") }
        .build()

    mediaItem1.play()
}
