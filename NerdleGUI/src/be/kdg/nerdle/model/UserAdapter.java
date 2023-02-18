package be.kdg.nerdle.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class UserAdapter extends TypeAdapter<User> {
    @Override
    public void write(JsonWriter out, User value) throws IOException {
        out.beginObject();
        out.name("name");
        out.value(value.getName());
        out.name("scores");
        out.value((Number) value.getScores());
        out.endObject();
    }

    @Override
    public User read(JsonReader in) throws IOException {
        return null;
    }
}
