package utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

public class CsvUtil {
	
	public static <T> List<T> read(
			String path,
			Class<T> clazz) throws Exception {
		
		InputStream is =
				CsvUtil.class
						.getClassLoader()
						.getResourceAsStream(path);
		
		if(is == null) {
			throw new RuntimeException(
					"CSVファイルが見つかりません: " + path);
		}
		    
		return new CsvToBeanBuilder<T>(
				new InputStreamReader(
						is, StandardCharsets.UTF_8))
				.withType(clazz)
				.build()
				.parse();	
	}
}
