package me.dzikimlecz.timetables

import kotlinx.serialization.Serializable

@Serializable
data class TimeTableTransferredSurrogate(
    val date: String,
    val name: String,
    val table: List<List<String>>,
    val timeSpans : List<Array<String?>>
)

