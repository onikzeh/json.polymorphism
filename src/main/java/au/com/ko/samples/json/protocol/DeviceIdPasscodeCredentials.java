package au.com.ko.samples.json.protocol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Authentication parameter to be submitted for deviceId/passcode type
 * authentication.
 */
@JsonTypeName(DeviceIdPasscodeCredentials.CREDENTIAL_TYPE)
public class DeviceIdPasscodeCredentials extends Credentials {

	static final String CREDENTIAL_TYPE = "deviceId";
	private final String deviceId;
	private final int passcode;
	private final int deviceSerial;


	@JsonCreator
	public DeviceIdPasscodeCredentials(@JsonProperty("deviceId") String deviceId,
									   @JsonProperty("passcode") int passcode,
									   @JsonProperty("deviceSerial") int deviceSerial) {
		super(CREDENTIAL_TYPE);
		this.deviceId = deviceId;
		this.passcode = passcode;
		this.deviceSerial = deviceSerial;
	}

	/**
	 * The registered user device identifier.
	 *
	 * @return the device ID.
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * The registered device passcode.
	 *
	 * @return the passcode value.
	 */
	public int getPasscode() {
		return passcode;
	}

	public int getDeviceSerial() {
		return deviceSerial;
	}
}
