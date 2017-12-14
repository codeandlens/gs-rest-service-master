package game.model;

import java.util.List;

public class Node {
	
	private String Title;
	private String Desc;
	private List<Images> Images;
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	public List<Images> getImages() {
		return Images;
	}
	public void setImages(List<Images> images) {
		Images = images;
	}
	
	
	
}
