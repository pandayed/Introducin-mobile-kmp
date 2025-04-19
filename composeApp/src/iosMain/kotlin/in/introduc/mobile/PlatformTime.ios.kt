import kotlin.time.TimeSource

actual fun getCurrentTimeMillis(): Long {
    return TimeSource.Monotonic.markNow().elapsedNow().inWholeMilliseconds
}