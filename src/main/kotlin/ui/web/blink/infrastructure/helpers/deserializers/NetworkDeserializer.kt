package ui.web.blink.infrastructure.helpers.deserializers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import ui.web.blink.domain.entities.Network
import java.io.IOException


class NetworksDeserializer : JsonDeserializer<Any?>() {
    @Throws(IOException::class)
    override fun deserialize(
        jsonParser: JsonParser,
        deserializationContext: DeserializationContext?
    ): List<Network> {
        val objectCodec: ObjectCodec = jsonParser.getCodec()
        val node: JsonNode = objectCodec.readTree(jsonParser)
        val networks = mutableListOf<Network>()
        node.fields().forEach {
            networks.add(
                Network(
                    it.key.toInt(),
                    it.value.get("name").textValue(),
                    it.value.get("onboarded").booleanValue()
                )
            )
        }
        return networks
    }
}