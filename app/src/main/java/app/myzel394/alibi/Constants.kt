package app.myzel394.alibi

val SUPPORTED_LOCALES = arrayOf("en-US", "zh-CN", "de-DE", "tr-TR")

// Broadcast actions to control audio recording externally (e.g. from Tasker).
// Received by RecorderIntentReceiver, which starts/stops the recording service
// headlessly — no activity, no UI. See receivers/RecorderIntentReceiver.kt.
const val INTENT_ACTION_START_AUDIO_RECORDING = "app.myzel394.alibi.action.START_AUDIO_RECORDING"
const val INTENT_ACTION_STOP_AUDIO_RECORDING = "app.myzel394.alibi.action.STOP_AUDIO_RECORDING"

// Internal service actions (AudioRecorderService.onStartCommand).
const val SERVICE_ACTION_START = "app.myzel394.alibi.service.START"
const val SERVICE_ACTION_STOP = "app.myzel394.alibi.service.STOP"