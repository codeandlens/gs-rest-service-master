package com.itg.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {

	static final int MAX_WIDTH = 250;
	static final int MAX_HEIGHT = 250;
	
	private String image1;
    private String image2;
    private String image3;

}
