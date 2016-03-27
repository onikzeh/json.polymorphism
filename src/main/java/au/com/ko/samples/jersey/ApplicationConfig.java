package au.com.ko.samples.jersey;

import au.com.ko.samples.jersey.LoginService;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		super(JacksonFeature.class, LoginService.class);
	}
}
