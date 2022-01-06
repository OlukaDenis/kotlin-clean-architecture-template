package com.mcash.client.data.local.serializers

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.mcash.client.UserPreference
import java.io.InputStream
import java.io.OutputStream

object UserPreferenceSerializer : Serializer<UserPreference> {
    override val defaultValue: UserPreference = UserPreference.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserPreference = try {
            UserPreference.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }

    override suspend fun writeTo(t: UserPreference, output: OutputStream) = t.writeTo(output)
}