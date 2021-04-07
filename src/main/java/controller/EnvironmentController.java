package controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;

@UtilityClass
@Slf4j
public class EnvironmentController {

    // use explicit charset so we keep common behaviour across platforms
    @NotNull
    @Contract("_ -> new")
    private InputStreamReader getFileReader(String filePath) throws FileNotFoundException {
        return new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
    }

    // return resource file contents as JsonObject
    public JsonObject getJsonObject(String file) throws IOException {
        String path = System.getProperty("user.dir");
        Gson gson = new Gson();
        return gson.fromJson(getFileReader(path + "/src/main/java/resources/requestPayloads/" + file + ".json"),JsonObject.class);
    }
}
