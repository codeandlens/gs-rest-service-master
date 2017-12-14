package game;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import game.model.CentralRequestModel;
import game.model.CentralResponseModel;
import game.model.Content;

@RestController
public class GameController {
	
	@RequestMapping(value = "/is_activated", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseBody
	public CentralResponseModel checkConnectCentral(@RequestBody CentralRequestModel request) {
		String ip = request.getIp();
		CentralResponseModel response = new CentralResponseModel();
		
		try {
			
			/*
			 * API Call Central Is_actiated
			 */
			response.setCode("200");
			Content contents = new Content();
			contents.setStatus("OK");
			response.setContents(contents);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return response;
	}
	
	
	@RequestMapping(value = "/activated", method = RequestMethod.POST, consumes = {"application/json"})
    @ResponseBody
	public CentralResponseModel connertCentral(@RequestBody CentralRequestModel request) {
		
		String ip = request.getIp();
		String port = request.getPort();
		
		CentralResponseModel response = new CentralResponseModel();
		
		try {
			
			
			 /*
			  *  API Call Central actiated  GET Method
			  */
			
			response.setCode("200");
			Content contents = new Content();
			contents.setStatus("OK");
			response.setContents(contents);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	
	
	
	
}
