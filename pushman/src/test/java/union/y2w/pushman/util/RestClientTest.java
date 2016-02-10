package union.y2w.pushman.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import union.y2w.pushman.util.RestClient;

public class RestClientTest {
	
	RestClient restClient;

	@Before
	public void setUp() throws Exception {
		restClient = new RestClient();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
		public void testSendByPOST() throws Exception {
			
			Map<String, String> data = new HashMap<String, String>();
			data.put("message", "오늘 영모야! sukses успех सफलता  成功 موفقیت úspěch");
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("data", data);
			params.put("to", "eelxIibloS8:APA91bG-xWHGD33A1mz-ouoZIZGQpZjw0DSQWNajvaZred6Le-LfQapeqo7gjmhw0e3b71YxdkgqzVmc0mOuvVxCnfQolpkiJj4ZmXCg-E8HrwB-DzSiOKd9Rw-kVSrRN3I5s9-jXLHv");
			params.put("priority", "high");
			
			restClient.setUrl("https://gcm-http.googleapis.com/gcm/send");
			restClient.setHeader("Authorization", "key=AIzaSyC-KFuFXVbAYwbwwLqgeddBELXeyxxB824");
			restClient.setBody(params);
			
			HttpStatus status = restClient.sendByPOST();
			
			assertEquals(HttpStatus.OK, status);
			
			System.out.println(status.name());
			System.out.println(restClient.getResponse());
		}

}
