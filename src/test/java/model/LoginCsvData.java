package model;

import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class LoginCsvData {
	
	@CsvBindByName
	private String name;

	@CsvBindByName
	private String username;
	
	@CsvBindByName
	private String password;
	
	@CsvBindByName
    private int statusCode;
	
	@CsvBindByName
    private String expectedUsername;
	    
}
