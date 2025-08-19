package tests.api;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import static org.awaitility.Awaitility.await;

public class Uthils {
    public static void waitForStatusCode(Supplier<Integer> statusCodeSupplier, int expectedStatusCode) {
        await()
                .atMost(10, TimeUnit.SECONDS)
                .pollInterval(500, TimeUnit.MILLISECONDS)
                .until(() -> statusCodeSupplier.get() == expectedStatusCode);
    }
}
