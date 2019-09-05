package co.pushe.plus.utils

import java.util.concurrent.TimeUnit
import kotlin.math.absoluteValue


open class Time(val time: Long, val timeUnit: TimeUnit) {
    constructor(time: Int, timeUnit: TimeUnit) : this(time.toLong(), timeUnit)

    fun toMillis() = timeUnit.toMillis(time)
    fun toSeconds() = timeUnit.toSeconds(time)
    fun toMinutes() = timeUnit.toMinutes(time)
    fun toHours() = timeUnit.toHours(time)
    fun toDays() = timeUnit.toDays(time)

    override fun toString(): String = toMillis().toString()
    override fun equals(other: Any?): Boolean = other is Time && toMillis() == other.toMillis()
    override fun hashCode(): Int = toMillis().hashCode()

    operator fun plus(other: Time): Time = Time(toMillis() + other.toMillis(), TimeUnit.MILLISECONDS)
    operator fun minus(other: Time): Time = Time(toMillis() - other.toMillis(), TimeUnit.MILLISECONDS)
    operator fun compareTo(other: Time): Int = toMillis().compareTo(other.toMillis())
    fun abs(): Time = Time(time.absoluteValue, timeUnit)

    fun bestRepresentation(): String {
        val second = 1000
        val minute = second * 60
        val hour = minute * 60
        val day = hour * 24
        var result = ""
        var time = toMillis()

        if (time == 0L) {
            return "0"
        }

        (time / day).let { if (it > 0) result = "$it days" }
        time %= day
        (time / hour).let { if (it > 0) result = "$result $it hours" }
        time %= hour
        (time / minute).let { if (it > 0) result = "$result $it minutes" }
        time %= minute
        (time / second).let { if (it > 0) result = "$result $it seconds" }
        time %= second
        if (time > 0) result = "$result $time milliseconds"
        return result
    }
}

fun millis(millis: Long) = Time(millis, TimeUnit.MILLISECONDS)
fun seconds(seconds: Long) = Time(seconds, TimeUnit.SECONDS)
fun minutes(minutes: Long) = Time(minutes, TimeUnit.MINUTES)
fun hours(hours: Long) = Time(hours, TimeUnit.HOURS)
fun days(days: Long) = Time(days, TimeUnit.DAYS)