package au.com.ko.samples.json.protocol;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Container (base class) for alternative possible user credentials submitted
 * during authentication.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "credentialType")
@JsonSubTypes({ @Type(UsernamePasswordCredentials.class), @Type(DeviceIdPasscodeCredentials.class)})
public class Credentials {

	private final String credentialType;

	Credentials(String credentialType) {
		this.credentialType = credentialType;
	}

	/**
	 * Identify the specific type of credentials found in this JSON object.
	 *
	 * @return the credentials type identifier.
	 */
	@JsonTypeId
	public String getCredentialType() {
		return credentialType;
	}
}
