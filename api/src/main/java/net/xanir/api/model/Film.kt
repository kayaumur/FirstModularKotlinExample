package net.xanir.api.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Umur Kaya on 29-Sep-19.
 */
data class Film(
    @SerializedName("opening_crawl")
    val openingCrawl: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val title: String?
)