package com.capstone.arahku.model.response

import com.google.gson.annotations.SerializedName

data class MajorResponse(

    @field:SerializedName("data")
    val data: MajorData? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)

data class MajorData(

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String? = null
)

data class MajorBody(

    @field:SerializedName("search")
    val search_key: String? = null
)
