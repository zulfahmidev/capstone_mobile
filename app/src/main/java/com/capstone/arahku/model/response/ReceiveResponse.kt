package com.capstone.arahku.model.response


import com.google.gson.annotations.SerializedName

data class ReceiveResponse(

    @field:SerializedName("data")
    val data: DataReceive? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)

data class FormId(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("title")
    val title: String? = null
)

data class DataReceive(

    @field:SerializedName("result")
    val result: String? = null,

    @field:SerializedName("user_id")
    val userId: UserId? = null,

    @field:SerializedName("form_id")
    val formId: FormId? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("responses")
    val responses: List<Responses?>? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class UserId(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class Responses(

    @field:SerializedName("response_id")
    val responseId: Int? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("option_id")
    val optionId: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null
)
