package au.com.ko.samples.systest;

import au.com.ko.samples.json.protocol.Credentials;
import au.com.ko.samples.json.protocol.DeviceIdPasscodeCredentials;
import au.com.ko.samples.json.protocol.UsernamePasswordCredentials;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class LoginTest {

    @Test
    public void testLogin() throws IOException {

		Properties config = new Properties();
		config.load(LoginTest.class.getResourceAsStream("/config.properties"));

		String contextPath = config.getProperty("test.server.contextPath");
		int port = Integer.parseInt(config.getProperty("test.server.port"));

		URI baseURI = UriBuilder
				.fromUri("http://localhost/")
				.port(port)
				.build();

		WebTarget target = ClientBuilder.newClient()
				.target(baseURI + contextPath + "/login");

		Credentials credentials = new UsernamePasswordCredentials("testUser", "testPassword");

		String response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(credentials, MediaType.APPLICATION_JSON), String.class);

		assertEquals("UserName Password authentication failed", "OK", response);

		credentials = new DeviceIdPasscodeCredentials("testDeviceID", 12345, 8989898);
		response = target.request()
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(credentials, MediaType.APPLICATION_JSON), String.class);

		assertEquals("DeviceID Passcode authentication failed", "OK", response);
	}
}
