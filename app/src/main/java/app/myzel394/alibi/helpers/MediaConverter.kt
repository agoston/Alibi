package app.myzel394.alibi.helpers

import java.io.InputStream
import java.io.OutputStream

// Concatenates recording batches into a single file.
//
// The audio recorder writes self-framing streams (the default AAC/ADTS, and
// also AMR / MPEG-2-TS), so joining the batches is a plain byte-level append —
// no muxing or re-encoding, and therefore no FFmpeg. This is equivalent to the
// `-c copy` path the app used to run through ffmpeg-kit.
//
// NOTE: this only produces a valid file for stream formats. Container formats
// (MP4, OGG/Opus, WebM) are NOT byte-concatenable and are intentionally not
// offered as recording options anymore.
object MediaConverter {
    // Copies each input stream, in order, into [output]. All streams (inputs and
    // output) are closed when finished. [onProgress] is called with the number
    // of batches processed so far.
    fun concatenateStreams(
        inputs: List<InputStream>,
        output: OutputStream,
        onProgress: (batchesDone: Int) -> Unit = {},
    ) {
        output.use { out ->
            inputs.forEachIndexed { index, input ->
                input.use { it.copyTo(out) }
                onProgress(index + 1)
            }
        }
    }
}
