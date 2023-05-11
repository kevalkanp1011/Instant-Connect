package dev.kevalkanpariya.webrtcvideocalll.webrtc.audio


/**
 * Originally written by GetStream.
 *
 * https://github.com/GetStream/webrtc-in-jetpack-compose/
 */
internal interface AudioManagerAdapter {

    fun hasEarpiece(): Boolean

    fun hasSpeakerphone(): Boolean

    fun setAudioFocus()

    fun enableBluetoothSco(enable: Boolean)

    fun enableSpeakerphone(enable: Boolean)

    fun mute(mute: Boolean)

    fun cacheAudioState()

    fun restoreAudioState()
}