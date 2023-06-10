package com.capstone.arahku.model.source

import java.io.Serializable

data class University(
    val name: String,
    val description: String,
    val image: Int,
    val katingList: List<Kating>
): Serializable

data class Kating(
    val name:String,
    val semester: String,
    val image: Int
):Serializable
