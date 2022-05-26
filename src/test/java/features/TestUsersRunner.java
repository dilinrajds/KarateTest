package features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

public class TestUsersRunner {
	
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:features").parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}