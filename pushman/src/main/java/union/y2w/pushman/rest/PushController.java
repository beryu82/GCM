package union.y2w.pushman.rest;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import union.y2w.pushman.model.PushData;
import union.y2w.pushman.model.Result;
import union.y2w.pushman.model.ResultCode;
import union.y2w.pushman.model.ResultHandler;
import union.y2w.pushman.service.SendService;
import union.y2w.pushman.service.SendServiceFactory;

@RestController
public class PushController {
	
	private static final Logger logger = LoggerFactory.getLogger(PushController.class);
	
	@Autowired
	SendServiceFactory serviceFactory;
	
    @RequestMapping(value="/push/send", method=RequestMethod.POST)
    public Result send(@RequestParam Map<String, String> paramMap) {
    	
    	ResultHandler resHandler = new ResultHandler();
    	
    	PushData pushData = null;
    	SendService sendService = null;
    	
    	try {
    		pushData = resHandler.validateAndMakePushData(paramMap);
    		
    		sendService = serviceFactory.getInstance(pushData.getUserPlatform());
			sendService.send(pushData);
			
			resHandler.setCode(ResultCode.SUCCESS);
			
    	} catch (IllegalArgumentException iae) {
    		resHandler.setCode(ResultCode.FAILURE, iae.getMessage());
    		logger.debug(iae.getMessage());
		} catch (Exception e) {
			resHandler.setCode(ResultCode.ERROR, e.getMessage());
			e.printStackTrace();
		}
    	
        return resHandler.getResult();
    }

}
