package com.mcash.client.core.models.meals

import com.google.gson.annotations.SerializedName

data class MealEntity(
    @SerializedName("category_name")
    val categoryName: String,

    @SerializedName("rating")
    val rating: Int,

    @SerializedName("profile_pic")
    val profilePic: String?,

    @SerializedName("first_name")
    val firstName: String?,

    @SerializedName("last_name")
    val lastName: String?,

    @SerializedName("user_name")
    val username: String,

    @SerializedName("status")
    val status: String?,

    @SerializedName("is_blocked")
    val isBlocked: String,

    @SerializedName("meal_qty")
    val mealQty: String,

    @SerializedName("same")
    val same: String,

    @SerializedName("currency")
    val currency: String,

    @SerializedName("currencyNo")
    val currencyNo: String,

    @SerializedName("prefix")
    val prefix: String,

    @SerializedName("symbol_decimal")
    val symbolDecimal: String?,

    @SerializedName("symbol_hex")
    val symbolHex: String?,

    @SerializedName("id")
    val id: String,

    @SerializedName("user_id")
    val userId: String,

    @SerializedName("meal_pic")
    val mealPic: List<String> = emptyList(),

    @SerializedName("meal_price")
    val mealPrice: String,

    @SerializedName("meal_desc")
    val mealDesc: String,

    @SerializedName("available_from")
    val availableFrom: String,

    @SerializedName("available_to")
    val availableTo: String,

    @SerializedName("pickup_address")
    val pickup_address: String,

    @SerializedName("is_always")
    val isAlways: String,

    @SerializedName("creation_datetime")
    val creationDatetime: String,

    @SerializedName("expire_date")
    val expireDate: String,

    @SerializedName("meal_name")
    val mealName: String,

    @SerializedName("is_display")
    val isDisplay: String,

    @SerializedName("reqs")
    val reqs: String,

    @SerializedName("delivery_time")
    val deliveryTime: String,

    @SerializedName("enc_id")
    val encId: String,

//    @SerializedName("review_list")
//    val reviewList: List<String>,

    @SerializedName("post_at")
    val postAt: String
)