package union.y2w.pushman.service;

import union.y2w.pushman.model.PushData;

public interface SendService {
	void send(PushData pushData) throws Exception;
}
