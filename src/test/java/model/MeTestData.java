package model;

import lombok.Data;

@Data
public class MeTestData {
	
	private Login login;
	private Me me;
	
	@Data
	public static class Login {
		private LoginRequest request;
		private LoginExpected expected;
	}
	
	@Data
    public static class LoginRequest {
        private String username;
        private String password;
    }
	
	@Data
    public static class LoginExpected {
        private int status;
    }
	
    @Data
    public static class Me {
        private MeExpected expected;
    }

    @Data
    public static class MeExpected {
        private int status;
        private String username;
        private String gender;
    }
}
