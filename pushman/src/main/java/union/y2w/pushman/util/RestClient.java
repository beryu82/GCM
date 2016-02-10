package union.y2w.pushman.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestClient {
	
	RestTemplate restTemplate = null;
	ObjectMapper objectMapper = null;
	
	HttpHeaders headers = null;
	HttpStatus responseCode = null;
	
	String body = null;
	String url = null;
	String responseBody = null;
	
	
	public RestClient() {
		restTemplate = new RestTemplate();
		objectMapper = new ObjectMapper();
		headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
	}

	public void setHeader(String name, String value) {
		headers.set(name, value);
	}
	
	public void setBody(Map<String, Object> paramMap) {
		try {
			body = objectMapper.writeValueAsString(paramMap);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public HttpStatus sendByPOST() throws Exception {
		
		HttpEntity<String> requestEntity = null;
		ResponseEntity<String> result = null;
		
		try {
			
			requestEntity = new HttpEntity<String>(body, headers);
			
			result = restTemplate.postForEntity(url, requestEntity, String.class);
			
			if (result != null) {
				responseCode = result.getStatusCode();
				responseBody = result.getBody();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		
		return responseCode;
	}
	
	public String getResponse() {
		return responseBody;
	}

}
