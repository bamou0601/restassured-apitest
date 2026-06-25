package model;

import lombok.Data;

@Data
public class RefreshTestData {
	
	private Login login;
	private Refresh refresh;
	
	@Data
	public static class Login {
		private Request request;
		private LoginExpected expected;
	}
	
	@Data
    public static class Request {
        private String username;
        private String password;
    }
	
	@Data
    public static class LoginExpected {
        private int status;
    }
	
    @Data
    public static class Refresh {
        private RefreshExpected expected;
    }

    @Data
    public static class RefreshExpected {
        private int status;
        private Boolean accessToken;
        private Boolean refreshToken;
    }
}
