package me.dzikimlecz.lecturers

import java.time.LocalDate
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE


data class SettlingPeriod(
    val start: LocalDate,
    val end: LocalDate = start.plusDays(4),
) {
    init { require (start < end) { "Start date: $start must be earlier than the end date: $end" } }

    override fun toString(): String = "{${start.format(ISO_LOCAL_DATE)}::${end.format(ISO_LOCAL_DATE)}}"

    operator fun contains(date: LocalDate) = date in start..end

    companion object {
        private val pattern = Regex("\\{\\d{4}(-\\d{2}){2}::\\d{4}(-\\d{2}){2}}")

        fun of(string: String): SettlingPeriod {
            require(validate(string)) { "Invalid value for a Settling Period: $string" }
            val dates = string.trim().removePrefix("{").removeSuffix("}").split("::")
            return SettlingPeriod(LocalDate.parse(dates[0]), LocalDate.parse(dates[1]),)
        }

        fun validate(string: String) = pattern.matches(string.trim())
    }
}
