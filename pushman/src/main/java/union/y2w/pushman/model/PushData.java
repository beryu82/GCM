package union.y2w.pushman.model;

public class PushData {
	
	/**
	 * Push Data ID
	 */
	private String id;
	
	/**
	 * User Token
	 * (GCM Registration ID, APNs Device Token...) 
	 */
	private String userToken;
	
	/**
	 * User Platform
	 * (ANDROID, IOS...)
	 */
	private PushPlatform userPlatform;
	
	/**
	 * Notification Message ID
	 */
	private String messageId;
	
	/**
	 * Notification Message
	 */
	private String messageText;
	
	/**
	 * Payload
	 */
	private String payload;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public PushPlatform getUserPlatform() {
		return userPlatform;
	}

	public void setUserPlatform(PushPlatform userPlatform) {
		this.userPlatform = userPlatform;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushData [id=").append(id).append(", userToken=").append(userToken).append(", userPlatform=")
				.append(userPlatform).append(", messageId=").append(messageId).append(", messageText=")
				.append(messageText).append(", payload=").append(payload).append("]");
		return builder.toString();
	}
	
}
