package test.java.file;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;

import com.intuit.karate.junit5.Karate;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class SimpleMockServerTestRunner {

	private static ClientAndServer mockServer;

	@BeforeAll
	public static void startMockServer() throws IOException, ParseException {
		mockServer = startClientAndServer(0);
		
		
		JSONParser jsonParser = new JSONParser();
		System.out.println(new File("mockValue.json").getAbsoluteFile());
		FileReader reader = new FileReader("mockValue.json");
		Object obj = jsonParser.parse(reader);

		JSONArray responseList = (JSONArray) obj;
		System.out.println(responseList);
		
		int i = 1;
		for (Object o : responseList) {
			JSONObject response = (JSONObject) o;
			new MockServerClient("localhost", mockServer.getLocalPort())
					.when(request(response.get("keyValue" + i).toString()))
					.respond(response().withBody(response.get("response" + i).toString()));
			i++;
		}
	}

	public int getServerPort() {
		int port = mockServer.getLocalPort();
		return port;
	}

	@AfterAll
	public static void stopMockServer() {
		mockServer.stop();
	}

	@Karate.Test
	Karate simpleTest() {

		return Karate.run("callApi.feature").relativeTo(getClass());
	}
}