package me.dzikimlecz.lecturers

import kotlinx.serialization.Required
import kotlinx.serialization.Serializable

@Serializable
data class LecturerTransferredSurrogate(
    val name: String,
    @Required val code: String =
        name.split(Regex("\\s"))
            .joinToString(separator = "") { it[0].toString().uppercase() },
    val hoursWorked: Map<String, Int>,
) {
    fun toLecturer() =
        Lecturer(name, code, hoursWorked.mapKeys { SettlingPeriod.of(it.key) })
}
