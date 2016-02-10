package union.y2w.pushman.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RestTemplateTests {

	RestTemplate restTemplate = new RestTemplate();
	ObjectMapper objectMapper = new ObjectMapper();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		String url = "https://gcm-http.googleapis.com/gcm/send";
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("message", "영모야! sukses успех सफलता  成功 موفقیت úspěch");
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("data", data);
		params.put("to", "eelxIibloS8:APA91bG-xWHGD33A1mz-ouoZIZGQpZjw0DSQWNajvaZred6Le-LfQapeqo7gjmhw0e3b71YxdkgqzVmc0mOuvVxCnfQolpkiJj4ZmXCg-E8HrwB-DzSiOKd9Rw-kVSrRN3I5s9-jXLHv");
		params.put("priority", "high");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("Authorization", "key=AIzaSyC-KFuFXVbAYwbwwLqgeddBELXeyxxB824");

		String body = null;
		try {
			body = objectMapper.writeValueAsString(params);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		HttpEntity<String> entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> result = null;
				
		try {
			result = restTemplate.postForEntity(url, entity, String.class);
		} catch (RestClientException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println(result);
		
		System.out.println(result.getStatusCode().toString());
		System.out.println(result.getBody());
		System.out.println(result.getHeaders());
		
		HttpHeaders header = result.getHeaders();
		Set<String> keys = header.keySet();
		for (String key : keys) {
			System.out.println(key + " : " + header.get(key));
		}
	}

}
