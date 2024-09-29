package dev.akarah.codeblocks.flow;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import dev.akarah.codeblocks.CodeBlock;
import dev.akarah.codeblocks.arguments.Args;

import java.util.List;

public record PlayerEvent(
    String action
) implements CodeBlock {
    public static class Serializer implements JsonSerializer<PlayerEvent> {
        @Override
        public JsonElement serialize(PlayerEvent bracket, java.lang.reflect.Type type, JsonSerializationContext jsonSerializationContext) {
            var je = new JsonObject();
            je.addProperty("id", "block");
            je.addProperty("block", "event");
            je.addProperty("action", bracket.action);
            je.addProperty("attribute", "LS-CANCEL");
            je.add("args", jsonSerializationContext.serialize(new Args(List.of())));
            return je;
        }
    }
}
