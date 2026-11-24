package org.tidepool.sdk.deserialization

import com.google.gson.*
import java.lang.reflect.Type
import java.time.Instant
import java.time.format.DateTimeFormatter

private val formatter = DateTimeFormatter.ISO_DATE_TIME;

class InstantSerializer : JsonSerializer<Instant>, JsonDeserializer<Instant> {
    
    override fun serialize(
        src: Instant?,
        typeOfSrc: Type?,
        context: JsonSerializationContext
    ): JsonElement {
        return context.serialize(src.toString(), String::class.java)
    }
    
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext
    ): Instant {
        return formatter.parse(context.deserialize(json, String::class.java), Instant::from)
    }
    
}