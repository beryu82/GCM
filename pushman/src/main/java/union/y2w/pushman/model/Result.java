package union.y2w.pushman.model;

import java.io.Serializable;

public class Result implements Serializable {
	
	private static final long serialVersionUID = -4713482743850062285L;
	

	String code;
	
	String message;
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Result [code=").append(code).append(", message=").append(message).append("]");
		return builder.toString();
	}

}
