package com.eduardovpessoa.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Profiles (
    @SerialName("People")
    val people: List<Profile>? = null
)

@Serializable
data class Profile(
    @SerialName("Name")
    val name: String? = null,

    @SerialName("Title")
    val title: String? = null,

    @SerialName("Phone")
    val phone: String? = null,

    @SerialName("Street")
    val street: String? = null,

    @SerialName("City")
    val city: String? = null,

    @SerialName("State")
    val state: String? = null,

    @SerialName("Zipcode")
    val zipcode: String? = null,

    @SerialName("Email")
    val email: String? = null,

    @SerialName("Birthday")
    val birthday: String? = null,

    @SerialName("Picture")
    val picture: String? = null
)
