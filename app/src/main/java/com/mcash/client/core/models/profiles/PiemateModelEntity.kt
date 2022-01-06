package com.mcash.client.core.models.profiles

import com.google.gson.annotations.SerializedName

data class PiemateModelEntity(
    @SerializedName("user_id")
    val userId: String,

    @SerializedName("profile_status")
    val profileStatus: String?,

    @SerializedName("profile_pic")
    val profilePic: String?,

    @SerializedName("first_name")
    val firstName: String?,

    @SerializedName("last_name")
    val lastName: String?,

    @SerializedName("user_name")
    val username: String,

    @SerializedName("follow_status")
    val followStatus: String?,

    @SerializedName("countpiemates")
    val piematesCount: String,

    @SerializedName("countfollowers")
    val followerCount: String?,

    @SerializedName("status")
    val status: String?,

    @SerializedName("email_id")
    val email: String
)
