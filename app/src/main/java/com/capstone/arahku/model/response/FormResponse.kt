package com.capstone.arahku.model.response

import com.google.gson.annotations.SerializedName

data class FormResponse(

    @field:SerializedName("data")
    val data: FormData? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: Boolean? = null
)

data class FieldsItemForm(

    @field:SerializedName("options")
    val options: List<OptionsItemForm?>? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("label")
    val label: String? = null,

    var selectedOptionId: Int? = null
)

data class OptionsItemForm(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("value")
    val value: String? = null,

    var isChecked: Boolean?
)

data class FormData(

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("fields")
    val fields: List<FieldsItemForm?>? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("slug")
    val slug: String? = null
)
