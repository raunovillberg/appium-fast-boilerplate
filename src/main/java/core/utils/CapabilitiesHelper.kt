package core.utils

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import java.io.IOException

object CapabilitiesHelper {
    @Throws(IOException::class)
    fun readAndMakeCapabilities(fileName: String): Map<String, *> {
        val capabilitiesAsJsonString = FileReader().readFile(fileName)
        val json = Json.parseToJsonElement(capabilitiesAsJsonString)
        return json.jsonObject.toMap<String, JsonElement>()
            .mapValues<String, JsonElement, String> { it.value.jsonPrimitive.content }
    }
}
