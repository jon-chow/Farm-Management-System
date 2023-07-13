package com.server.util.parsing;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.server.model.enums.AnimalType;

import java.io.IOException;

public class AnimalTypeAdapter extends TypeAdapter<AnimalType> {

    @Override
    public void write(JsonWriter out, AnimalType value) throws IOException {
        out.value(value.name());
    }

    @Override
    public AnimalType read(JsonReader in) throws IOException {
        String value = in.nextString();
        try {
            return AnimalType.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case when the enum value is not valid
            return AnimalType.ALL; // Or any other default value
        }
    }
}

