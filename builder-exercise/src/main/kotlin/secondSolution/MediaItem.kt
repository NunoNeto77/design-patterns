package secondSolution

class MediaItem private constructor() {

        private var name: String = ""
        private var artist: String = ""
        private var album: String? = null
        private var durationInSec: Long? = null
        private var beforePlaying: () -> Unit = {}

        fun play() {
            println("***\nPlaying MediaItem\n***")
            println("Name: $name")
            println("Artist: $artist")
            album?.let{ println("Album: $it") }
            durationInSec?.let { println("Duration: ${it}s") }

            beforePlaying()

            // Start playing the 'MediaItem'...
        }

        class Builder(val name: String, val artist: String) {

            val mediaItem = MediaItem().apply {
                name = this@Builder.name
                artist = this@Builder.artist
            }

            fun album(album: String) = apply { mediaItem.album = album }
            fun durationInSec(durationInSec: Long) = apply { mediaItem.durationInSec = durationInSec }
            fun beforePlaying(beforePlaying: () -> Unit) = apply { mediaItem.beforePlaying = beforePlaying }
            fun build() = mediaItem

        }
    }

    class VolumeController() {
        fun setVolume(volume: Int) {
            println("--- Setting volume to $volume")
        }
    }

    class BackgroundController() {
        fun setBackgroundColor(color: String) {
            println("--- Setting background color to $color")
        }
    }

    fun main() {
        val mediaItem0 = MediaItem.Builder("I Am Mine", "Pearl Jam")
            .album("Riot Act")
            .durationInSec(215L)
            .beforePlaying({ VolumeController().run{ setVolume(100) } })
            .build()
        mediaItem0.play()

        Thread.sleep(3000L)
        println("")

        val mediaItem1 = MediaItem.Builder("Poker Face", "Lady Gaga")
            .beforePlaying({ BackgroundController().run{ setBackgroundColor("yellow") } })
            .build()
        mediaItem1.play()
    }

