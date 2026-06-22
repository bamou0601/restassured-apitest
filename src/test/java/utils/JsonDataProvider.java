package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.LoginTestData;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonDataProvider {

    private static final ObjectMapper mapper =
            new ObjectMapper();

    public static <T> List<T> readList(
    			String path,
    			TypeReference<List<T>> type)
            throws IOException {

        InputStream is =
                JsonDataProvider.class
                        .getClassLoader()
                        .getResourceAsStream(path);

        return mapper.readValue(is, type);
    }
}