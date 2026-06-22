package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties =
			new Properties();
	
	static {
		try(InputStream is = 
				ConfigReader.class
					.getClassLoader()
					.getResourceAsStream("config.properties")) {
			
			properties.load(is);		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getBaseUrl() {

        return System.getProperty("base.url", "https://dummyjson.com");
    }
	
//	private static final Properties properties = new Properties();
//	
//	static {
//		
//		String env = System.getProperty("env", "dev");
//		
//		try (InputStream input = 
//				ConfigReader.class
//					.getClassLoader()
//					.getResourceAsStream("config/" + env + ".properties")) {
//			properties.load(input);
//		} catch (IOException e) {
//			throw new RuntimeException("Failed to load config file for environment: " + env, e);
//			
//		}
//		
//	}
//	
//	public static String getBaseUrl() {
//		return properties.getProperty("base.url");
//	}
	
}
