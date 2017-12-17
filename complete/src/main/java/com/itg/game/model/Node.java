package com.itg.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {

	static final int MAX_LENGTH_TITLE = 256;
	static final int MAX_LENGTH_DESCRIPTION = 1024;

	private String title;
	private String desc;
	private Images images;

}
