package dev.kevalkanpariya.webrtcvideocalll.webrtc.audio


/**
 * Originally written by GetStream.
 *
 * https://github.com/GetStream/webrtc-in-jetpack-compose/
 */

typealias AudioDeviceChangeListener = (
    audioDevices: List<AudioDevice>,
    selectedAudioDevice: AudioDevice?
) -> Unit