package ui.web.blink.infrastructure.helpers

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import ui.web.blink.domain.entities.Region
import java.io.IOException

class RegionDeserializer : JsonDeserializer<Any?>() {
    @Throws(IOException::class)
    override fun deserialize(
        jsonParser: JsonParser,
        deserializationContext: DeserializationContext?
    ): Region {
        val objectCodec: ObjectCodec = jsonParser.getCodec()
        val node: JsonNode = objectCodec.readTree(jsonParser)
        var region: Region = Region("", "");

        node.fields().forEach {
            region = Region(
                it.key,
                it.value.textValue()
            )
        }
        return region
    }
}