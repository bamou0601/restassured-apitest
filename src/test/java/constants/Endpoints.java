package constants;


public class Endpoints {
	
	private Endpoints() {}
	
	//authに関するAPI
	public static final String AUTH_LOGIN = "/auth/login";
	public static final String AUTH_ME = "/auth/me";
	public static final String AUTH_REFRESH = "/auth/refresh";
	
	//usersに関するAPI
	public static final String USERS = "/users";
	public static final String USERS_LOGIN = "/users/login";
	public static final String USERS_ME = "/users/me";
	public static final String USERS_1 = "/users/1";
	public static final String USERS_SEARCH = "/users/search";
	
	//productsに関するAPI
	public static final String PRODUCTS = "/products";
	public static final String PRODUCTS_1 = "/products/1";
	public static final String PRODUCTS_SEARCH = "/products/search";

}
