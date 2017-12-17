package game.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "content")
public class Content {
	
	@Id
	private String id;
	private String geokey;
	private Node node;
	private String distance;
	private String status;
}
