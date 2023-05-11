package dev.kevalkanpariya.webrtcvideocalll

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.kevalkanpariya.webrtcvideocalll.ui.presentations.stage.StageScreen
import dev.kevalkanpariya.webrtcvideocalll.ui.presentations.videocall.VideoCallScreen
import dev.kevalkanpariya.webrtcvideocalll.ui.theme.WebRTCVideoCalllTheme
import dev.kevalkanpariya.webrtcvideocalll.webrtc.SignalingClient
import dev.kevalkanpariya.webrtcvideocalll.webrtc.peer.StreamPeerConnectionFactory
import dev.kevalkanpariya.webrtcvideocalll.webrtc.sessions.LocalWebRtcSessionManager
import dev.kevalkanpariya.webrtcvideocalll.webrtc.sessions.WebRtcSessionManager
import dev.kevalkanpariya.webrtcvideocalll.webrtc.sessions.WebRtcSessionManagerImpl

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestPermissions(arrayOf(Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO), 0)

        val sessionManager: WebRtcSessionManager = WebRtcSessionManagerImpl(
            context = this,
            signalingClient = SignalingClient(),
            peerConnectionFactory = StreamPeerConnectionFactory(this)
        )

        setContent {
            WebRTCVideoCalllTheme {
                CompositionLocalProvider(LocalWebRtcSessionManager provides sessionManager) {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        var onCallScreen by remember { mutableStateOf(false) }
                        val state by sessionManager.signalingClient.sessionStateFlow.collectAsState()

                        if (!onCallScreen) {
                            StageScreen(state = state) { onCallScreen = true }
                        } else {
                            VideoCallScreen()
                        }
                    }
                }
            }
        }
    }
}

