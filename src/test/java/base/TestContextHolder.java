package base;

public class TestContextHolder {
	
	private static final ThreadLocal<Throwable> throwableHolder = new ThreadLocal<>();
	
	public static void setThrowable(Throwable t) {
		throwableHolder.set(t);
	}
	
	public static Throwable getThrowable() {
		return throwableHolder.get();
	}
	
	public static void clear() {
		throwableHolder.remove();
	}
}
