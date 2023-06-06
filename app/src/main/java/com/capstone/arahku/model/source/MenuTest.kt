package com.capstone.arahku.model.source

import java.io.Serializable

data class MenuTest(
    val name : String,
    val description: String,
    val instruction: String,
    val image: Int,
    val photo: Int
): Serializable
