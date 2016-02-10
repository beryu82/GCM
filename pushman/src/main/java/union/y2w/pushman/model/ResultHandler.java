package union.y2w.pushman.model;

import java.util.Map;

import org.springframework.util.StringUtils;

public class ResultHandler {
	
	private Result result;
	
	public ResultHandler() {
		this.result = new Result();
	}

	public void setCode(ResultCode resultCode) {
		result.setCode(resultCode.getResCode());
		result.setMessage(resultCode.getMessage());
	}
	
	public void setCode(ResultCode resultCode, String resultMessage) {
		result.setCode(resultCode.getResCode());
		result.setMessage(resultMessage);
	}
	
	public PushData validateAndMakePushData(Map<String, String> paramMap) throws IllegalArgumentException {
		
		if (paramMap == null || paramMap.size() < 1) {
			throw new IllegalArgumentException("Parameter is empty.");
		}
		
		if ( StringUtils.isEmpty(paramMap.get("token")) ) {
			throw new IllegalArgumentException("token is empty.");
		}
		
		if ( StringUtils.isEmpty(paramMap.get("msg")) ) {
			throw new IllegalArgumentException("msg is empty.");
		}
		
		PushData pushData = new PushData();
		
		pushData.setMessageText(paramMap.get("msg"));
		pushData.setUserToken(paramMap.get("token"));
		pushData.setUserPlatform(PushPlatform.ANDROID);
		
		return pushData;
	}
	
	public Result getResult() {
		return result;
	}
}
