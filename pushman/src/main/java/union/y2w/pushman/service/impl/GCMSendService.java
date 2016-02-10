package union.y2w.pushman.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import union.y2w.pushman.model.PushData;
import union.y2w.pushman.service.SendService;
import union.y2w.pushman.util.RestClient;

/**
 * Sending for Google Cloud Messaging
 * 
 * @author y2w
 */
@Component(value="GCMSendService")
public class GCMSendService implements SendService {
	
	private static final Logger logger = LoggerFactory.getLogger(GCMSendService.class);
	
	public static final String GCM_SERVER_URL = "https://gcm-http.googleapis.com/gcm/send";
	public static final String GCM_API_KEY = "key=AIzaSyC-KFuFXVbAYwbwwLqgeddBELXeyxxB824";
	public static final String CONTENT_TYPE = "application/json";

	@Override
	public void send(PushData pushData) throws Exception {

		Map<String, String> dataMap = new HashMap<String, String>();
		dataMap.put("message", pushData.getMessageText());
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("data", dataMap);
		paramMap.put("to", pushData.getUserToken());
		paramMap.put("priority", "high");
		
		RestClient restClient = new RestClient();
		restClient.setUrl(GCM_SERVER_URL);
		restClient.setHeader("Authorization", GCM_API_KEY);
		restClient.setBody(paramMap);
		
		try {
			
			HttpStatus status = restClient.sendByPOST();
			
			if (logger.isInfoEnabled()) {
				logger.info(status.name());
				logger.info(restClient.getResponse());
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
