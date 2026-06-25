package utils;

import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    private static final ObjectMapper mapper =
            new ObjectMapper();

    public static <T> T read(
            String path,
            Class<T> clazz)
            throws Exception {

        InputStream is =
                JsonUtil.class
                        .getClassLoader()
                        .getResourceAsStream(path);
        
        if(is == null) {
			throw new RuntimeException(
					"jsonファイルが見つかりません: " + path);
		}

        return mapper.readValue(is, clazz);
    }
    
    public static String toJson(Object object) {
    		
    	try {
    		return mapper
    				.writerWithDefaultPrettyPrinter()
    				.writeValueAsString(object);
    	} catch (Exception e) {
    		throw new RuntimeException(
    				"JSON変換失敗", e);
    	}
    }
    
    
}
