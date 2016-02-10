package union.y2w.pushman.service.impl;

import org.springframework.stereotype.Component;

import union.y2w.pushman.model.PushData;
import union.y2w.pushman.service.SendService;

@Component(value="APNSSendService")
public class APNSSendService implements SendService {

	@Override
	public void send(PushData pushData) {
		// TODO Auto-generated method stub
		
	}

}
