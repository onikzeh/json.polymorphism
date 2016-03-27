package au.com.ko.samples.unittest;

import au.com.ko.samples.json.protocol.Credentials;
import au.com.ko.samples.json.protocol.DeviceIdPasscodeCredentials;
import au.com.ko.samples.json.protocol.UsernamePasswordCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test the JSON polymorphism functionality.
 */
@RunWith(JUnit4.class)
public class PolymorphismTest {

	@Test
	public void test_devicePasscode() throws IOException, URISyntaxException {
		ObjectMapper om = new ObjectMapper();

		URL url = PolymorphismTest.class.getResource("/devicePasscode.json");

		Credentials credentials;

		try (InputStream inputStream = url.openStream()) {
			credentials = om.readValue(inputStream, Credentials.class);
		}

		assertNotNull("Could not deserialize devicePasscode.json", credentials);
		assertTrue(credentials instanceof DeviceIdPasscodeCredentials);
	}

	@Test
	public void test_usernamePassword() throws IOException, URISyntaxException {
		ObjectMapper om = new ObjectMapper();

		URL url = PolymorphismTest.class.getResource("/userPassword.json");

		Credentials credentials;

		try (InputStream inputStream = url.openStream()) {
			credentials = om.readValue(inputStream, Credentials.class);
		}

		assertNotNull("Could not deserialize userPassword.json", credentials);
		assertTrue(credentials instanceof UsernamePasswordCredentials);
	}
}
