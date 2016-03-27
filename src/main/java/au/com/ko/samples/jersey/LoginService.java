package au.com.ko.samples.jersey;

import au.com.ko.samples.json.protocol.Credentials;
import au.com.ko.samples.json.protocol.DeviceIdPasscodeCredentials;
import au.com.ko.samples.json.protocol.UsernamePasswordCredentials;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Singleton
@Path("/")
public class LoginService {

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(Credentials credentials) {

		if(credentials instanceof UsernamePasswordCredentials){
			UsernamePasswordCredentials cred =
					(UsernamePasswordCredentials) credentials;

			if( cred.getUsername().equals("testUser") &&
				cred.getPassword().equals("testPassword")){
				return "OK";
			}

		}else if(credentials instanceof DeviceIdPasscodeCredentials) {
			DeviceIdPasscodeCredentials cred =
					(DeviceIdPasscodeCredentials) credentials;

			if( cred.getDeviceId().equals("testDeviceID") &&
					cred.getPasscode() == 12345){
				return "OK";
			}
		}

		return "Failed";
	}

}

