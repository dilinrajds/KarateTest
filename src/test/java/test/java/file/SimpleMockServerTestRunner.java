package test.java.file;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.mock.Expectation;
import org.mockserver.model.Parameter;

import com.intuit.karate.junit5.Karate;

public class SimpleMockServerTestRunner {

	private static ClientAndServer mockServer;

	@BeforeAll
	public static void startMockServer() throws IOException, ParseException {
		mockServer = startClientAndServer(9092);
		String body = "";
		String body2 = "";
		String body3 = "";

		JSONParser jsonParser = new JSONParser();
		System.out.println(new File("mockValue.json").getAbsoluteFile());
		FileReader reader = new FileReader("mockValue.json");
		Object obj = jsonParser.parse(reader);

		JSONArray responseList = (JSONArray) obj;
		System.out.println(responseList);

		for (Object o : responseList) {
			JSONObject response = (JSONObject) o;
			body = response.get("response1").toString();
			body2 = response.get("response2").toString();
			body3 = response.get("response3").toString();
		}

		Expectation[] expectations = new MockServerClient("localhost", mockServer.getLocalPort())
				.when(request("/ap/users/{userId}").withPathParameter(Parameter.param("userId", "1")))
				.respond(response().withBody(body));

		Expectation[] expectations2 = new MockServerClient("localhost", mockServer.getLocalPort())
				.when(request("/apusers/{userId}").withPathParameter(Parameter.param("userId", "1")))
				.respond(response().withBody(body2));

		Expectation[] expectations3 = new MockServerClient("localhost", mockServer.getLocalPort())
				.when(request("/apusers/{userId}").withPathParameter(Parameter.param("userId", "2")))
				.respond(response().withBody(body3));

	}

	@AfterAll
	public static void stopMockServer() {
		mockServer.stop();
	}

	@Karate.Test
	Karate simpleTest() {

		return Karate.run("callApi").relativeTo(getClass());
	}
}