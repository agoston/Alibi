package app.myzel394.alibi.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import app.myzel394.alibi.INTENT_ACTION_START_AUDIO_RECORDING
import app.myzel394.alibi.INTENT_ACTION_STOP_AUDIO_RECORDING
import app.myzel394.alibi.SERVICE_ACTION_START
import app.myzel394.alibi.SERVICE_ACTION_STOP
import app.myzel394.alibi.services.AudioRecorderService

// Receives external broadcasts (e.g. from Tasker) to start / save & stop the
// audio recording headlessly — no activity is launched, so it works with the
// screen off and the device locked.
//
// Prerequisites for a background start to succeed:
//   - the app is exempt from battery optimizations (or holds SYSTEM_ALERT_WINDOW), and
//   - targetSdk is 33 (see app/build.gradle) so the Android 14+ restriction on
//     starting a `microphone` foreground service from the background does not apply.
class RecorderIntentReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val serviceAction = when (intent.action) {
            INTENT_ACTION_START_AUDIO_RECORDING -> SERVICE_ACTION_START
            INTENT_ACTION_STOP_AUDIO_RECORDING -> SERVICE_ACTION_STOP
            else -> return
        }

        val serviceIntent = Intent(context, AudioRecorderService::class.java).apply {
            action = serviceAction
        }

        ContextCompat.startForegroundService(context, serviceIntent)
    }
}
