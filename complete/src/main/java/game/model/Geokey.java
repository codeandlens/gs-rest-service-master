package game.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Geokey {

	static final int RADIUS = 10000; // m
	private String latlong;
	// private String latitude;
	// private String longtitude;
	// private String radius;
}
