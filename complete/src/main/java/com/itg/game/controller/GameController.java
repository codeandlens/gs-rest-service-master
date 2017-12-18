package com.itg.game.controller;

import java.util.ArrayList;
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
import com.itg.game.model.ContentResponse;
import com.itg.game.model.Node;
import com.itg.game.model.ResponseModel;
import com.itg.game.repository.ContentRepository;

import game.util.DistanceCalculator;

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
		// String ip = request.getIp();
		// String port = request.getPort();

		String ip = "";
		String port = "";

		CentralResponseModel responseCallCentral = new CentralResponseModel();

		try {

			/*
			 * API Call Central actiated GET Method
			 */

			/*
			 * response.setCode("200"); Content contents = new Content();
			 * contents.setStatus("OK"); response.setContents(contents);
			 */

			response = "OK";

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = { "application/json" })
	public void create(@RequestBody Content content) {

		contentRepository.save(content);

	}

	@RequestMapping(value = "/inquire/{geokey}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseModel inquire(@PathVariable String geokey) {

		ResponseModel response = new ResponseModel();
		
		try {
			List<ContentResponse> list = new ArrayList<ContentResponse>();
			String[] latlon1 = geokey.split(":");
			double lat1 = Double.parseDouble(latlon1[0]);
			double lon1 = Double.parseDouble(latlon1[1]);

			List<Content> contents = contentRepository.findAll();
			for (Content content : contents) {
				String[] latlon2 = content.getGeokey().split(":");
				double lat2 = Double.parseDouble(latlon2[0]);
				double lon2 = Double.parseDouble(latlon2[1]);

				double distance = DistanceCalculator.distance(lat1, lon1, lat2, lon2, "K");
				System.out.println("distance:" + distance);
				if (distance >= 10) {
					ContentResponse contentRes = new ContentResponse();
					contentRes.setNode(content.getNode());
					list.add(contentRes);
				}
			}			

			if (list.isEmpty()) {
				response.setCode("422 NODE_NOT_FOUND");
				response.setContents(list);

			} else {
				response.setCode("200");
				response.setContents(list);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return response;

	}

}
