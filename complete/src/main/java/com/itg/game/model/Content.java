package com.itg.game.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "content")
public class Content {
	
	private String geokey;
	private Node node;
	private String status;
	
		
}
