package com.asana;

import com.asana.models.ResultBody;
import com.asana.models.StoryTest;
import com.google.common.reflect.TypeParameter;
import com.google.common.reflect.TypeToken;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * class to extend to write a test of API Model
 *
 * follows pattern already in asana client code base; although it is reuse-by-inheritance, so should probably be moved
 * to a util class/etc for a more modern approach
 *
 */
public class ModelTest {

    protected  <T> ResultBody<T> parse(Class<T> clazz, String pathToExampleResponse) {
        //TODO: how do we test for "complete" deserialization? (eg, all fields present in JSON mapped to Java?). Default
        // behavior in Jackson is to fail if incomplete deserialization, but GSON just ignores by default

        try {
            URL url = StoryTest.class.getClassLoader().getResource(pathToExampleResponse);
            if (url == null) {
                throw new IllegalArgumentException("No such file: " + pathToExampleResponse);
            }
            return Json.getInstance().fromJson(Files.newBufferedReader(Paths.get(url.toURI())),
                    new TypeToken<ResultBody<T>>() {}.where(new TypeParameter<T>() {}, clazz).getType()
            );
        } catch (IOException | URISyntaxException e) {
            throw new Error(e);
        }
    }

}
