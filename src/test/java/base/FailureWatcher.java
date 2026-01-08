package base;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.util.Optional;

public class FailureWatcher implements TestWatcher {
	
	@Override
	public void testFailed(ExtensionContext context, Throwable cause) {
		TestContextHolder.setThrowable(cause);
	}
	
	@Override
	public void testSuccessful(ExtensionContext context) {
		TestContextHolder.clear();
	}
}
