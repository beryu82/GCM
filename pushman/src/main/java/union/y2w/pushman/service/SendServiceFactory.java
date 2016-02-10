package union.y2w.pushman.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import union.y2w.pushman.model.PushPlatform;
import union.y2w.pushman.service.impl.APNSSendService;
import union.y2w.pushman.service.impl.GCMSendService;

@Component
public class SendServiceFactory {

	@Autowired
	GCMSendService gcmSendService;

	@Autowired
	APNSSendService apnsSendService;

	public SendServiceFactory() {
	}

	public SendService getInstance(PushPlatform platform) {

		switch (platform) {
		
		case ANDROID:
			return gcmSendService;
		case IOS:
			return apnsSendService;

		default:
			throw new IllegalArgumentException("Unknown platform!!");
		}
	}

}
