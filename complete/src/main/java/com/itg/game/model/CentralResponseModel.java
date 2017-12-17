package com.itg.game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CentralResponseModel {
	
	private String code;
	private Content contents;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Content getContents() {
		return contents;
	}
	public void setContents(Content contents) {
		this.contents = contents;
	}
	
	

}
