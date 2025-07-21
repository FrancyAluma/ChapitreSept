package com.example.chapitresept.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Cat (


    @SerialName("createdAt") val createdAt: String? = null,
    @SerialName("_id") val id: String = "",
    @SerialName("owner") val owner: String? = null,
    @SerialName("tags") val tags: List<String> = emptyList(),
    @SerialName("updatedAt") val updatedAt: String? = null


)