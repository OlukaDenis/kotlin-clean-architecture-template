package com.mcash.client.core.utils

import com.google.gson.Gson
import org.json.JSONObject
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class Utils {
    companion object{

        /**
         * A method that extracts and formats the error returned from an endpoint
         */
        fun resolveError(e: Throwable): String {
            var error = ""

            when (e) {
                is SocketTimeoutException -> {
                    error = "Connection error!"
                }
                is ConnectException -> {
                    error = "No internet access!"
                }
                is UnknownHostException -> {
                    error = "No internet access!"
                }

                is HttpException -> {
                    val errorBody = e.response()?.errorBody()?.string()
                    error = JSONObject(errorBody!!).getString("message")
                }
            }

            return error
        }
    }
}