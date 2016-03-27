package au.com.ko.samples.json.protocol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Authentication parameter to be submitted for username/password type
 * authentication.
 */
@JsonTypeName(UsernamePasswordCredentials.CREDENTIAL_TYPE)
public class UsernamePasswordCredentials extends Credentials {

	static final String CREDENTIAL_TYPE = "username";
	private final String username;
	private final String password;

	@JsonCreator
	public UsernamePasswordCredentials(@JsonProperty("username") String username,
									   @JsonProperty("password") String password) {
		super(CREDENTIAL_TYPE);
		this.username = username;
		this.password = password;
	}

	/**
	 * The registered user identifier.
	 *
	 * @return the username.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * The registered user's password.
	 *
	 * @return the password value.
	 */
	public String getPassword() {
		return password;
	}
}
