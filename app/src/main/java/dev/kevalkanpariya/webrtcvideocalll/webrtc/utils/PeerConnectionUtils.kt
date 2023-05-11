package dev.kevalkanpariya.webrtcvideocalll.webrtc.utils

import org.webrtc.AddIceObserver
import org.webrtc.IceCandidate
import org.webrtc.PeerConnection
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


/**
 * Originally written by GetStream.
 *
 * https://github.com/GetStream/webrtc-in-jetpack-compose/
 */

suspend fun PeerConnection.addRtcIceCandidate(iceCandidate: IceCandidate): Result<Unit> {
    return suspendCoroutine { cont ->
        addIceCandidate(
            iceCandidate,
            object : AddIceObserver {
                override fun onAddSuccess() {
                    cont.resume(Result.success(Unit))
                }

                override fun onAddFailure(error: String?) {
                    cont.resume(Result.failure(RuntimeException(error)))
                }
            }
        )
    }
}