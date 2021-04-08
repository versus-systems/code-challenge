package com.versus.androidcodetest

// Note: Quick and dirty - definitely do not use as is
object Helper {
    val baseUrl = "https://www.amiiboapi.com/api/"
    val amiiboUri = "amiibo/"

    data class AmiiboSummary (
        val character: String,
        val image: String,
        val amiiboSeries: String,
        val gameSeries: String?,
        val type: AmiiboType,
        val name: String
    )

    enum class AmiiboType {
        CARD, YARN, FIGURE, NONE
    }
}



