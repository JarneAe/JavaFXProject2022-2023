package be.kdg.nerdle.model.jsonmanager;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * TypeAdapter for LocalDate. Without this, writing and reading any User object from json will not work, as gson does
 * not work with LocalDate objects out of the box.
 *
 * @author robhe
 */
public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return LocalDate.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(
                src.format(DateTimeFormatter.ISO_LOCAL_DATE)
        );
    }
}

