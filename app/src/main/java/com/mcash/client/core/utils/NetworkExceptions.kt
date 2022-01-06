package com.mcash.client.core.utils

import org.json.JSONObject
import retrofit2.HttpException

/**
 * A util class that parses the error body that is received from an endpoint
 */
open class NetworkErrorException(
    val errorCode: Int = -1,
    val errorMessage: String,
    val response: String = ""
) : Exception() {
    override val message: String
        get() = localizedMessage

    override fun getLocalizedMessage(): String {
        return errorMessage
    }

    companion object {
        fun parseException(e: HttpException): NetworkErrorException {
            val errorBody = e.response()?.errorBody()?.string()

            return try {
                NetworkErrorException(e.code(), JSONObject(errorBody!!).getString("message"))
            } catch (_: Exception) {
                NetworkErrorException(e.code(), "Unexpected error!!ً")
            }
        }
    }
}

class AuthenticationException(authMessage: String) :
    NetworkErrorException(errorMessage = authMessage) {

    }