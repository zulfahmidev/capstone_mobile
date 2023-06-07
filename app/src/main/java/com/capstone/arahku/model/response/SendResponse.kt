package com.capstone.arahku.model.response


import com.google.gson.annotations.SerializedName

data class SendResponse(

    @field:SerializedName("user_id")
    val userId: Int? = null,

    @field:SerializedName("form_id")
    val formId: Int? = null,

    @field:SerializedName("responses")
    val responses: List<ResponsesItem?>? = null
)

data class ResponsesItem(

    @field:SerializedName("field_id")
    val fieldId: Int? = null,

    @field:SerializedName("option_id")
    val optionId: Int? = null
)