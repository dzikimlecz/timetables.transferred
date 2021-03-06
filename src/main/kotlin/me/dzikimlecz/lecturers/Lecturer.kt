package me.dzikimlecz.lecturers

import kotlin.collections.HashMap

data class Lecturer(
    val name: String,
    val code: String =
        name.trim().split(Regex("\\s"))
            .joinToString(separator = "") { it[0].toString().uppercase() },
    val hoursWorked: Map<SettlingPeriod, Int>
) {

    inline fun derive(
        name: String = this.name,
        code: String = this.code,
        instruction: MutableMap<SettlingPeriod, Int>.() -> Unit = {},
    ) = Lecturer(name, code, HashMap(hoursWorked).apply(instruction))

    fun toSurrogate(): LecturerTransferredSurrogate =
        LecturerTransferredSurrogate(name, code, hoursWorked.mapKeys { it.key.toString() })
}
