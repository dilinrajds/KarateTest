package features;

import com.intuit.karate.junit5.Karate;

public class TestUsersRunner {
	
	@Karate.Test
    Karate testParallel() {
    	return Karate.run("karateSetWithKarateCore").relativeTo(getClass());
    }
}