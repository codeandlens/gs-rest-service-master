package com.itg.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itg.game.model.CentralRequestModel;
import com.itg.game.model.CentralResponseModel;
import com.itg.game.model.Content;
import com.itg.game.model.Node;
import com.itg.game.repository.ContentRepository;

@RestController
public class GameController {

	@Autowired
	ContentRepository contentRepository;

	@Autowired
	MongoTemplate mongoTemplate;
		
	@RequestMapping(value = "/is_activated", method = RequestMethod.POST, consumes = { "application/json" })
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

	@RequestMapping(value = "/activated", method = RequestMethod.POST, consumes = { "application/json" })
	@ResponseBody
	public String connertCentral() {
		String response = "";
		//String ip = request.getIp();
		//String port = request.getPort();
		
		String ip = "";
		String port = "";

		CentralResponseModel responseCallCentral = new CentralResponseModel();

		try {

			/*
			 * API Call Central actiated GET Method
			 */

			/*response.setCode("200");
			Content contents = new Content();
			contents.setStatus("OK");
			response.setContents(contents);*/
			
			response = "OK";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" })
	public void create(@RequestBody Node node, @RequestBody String geokey) {

		Content content = new Content();
		content.setGeokey(geokey);
		content.setNode(node);
		
		contentRepository.save(content);

	}

	@RequestMapping(value = "/inquire",  method = RequestMethod.GET, produces = { "application/json" })
	public List<Content> inquire(@PathVariable String geokey) {

		Query query = new Query();
		//หา Node ทั้งหมดที่อยู่ในรัศมี 10 km
		query.addCriteria(Criteria.where("distance").lt(10000));

		return mongoTemplate.find(query, Content.class);
	}

}
