
/**
 * @author Alin Arhip
 *
 */
public class Location {
	private double[] location;

	public double getX() {
		return location[0];
	}

	public double getY() {
		return location[1];
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public Location(double[] location) {
		this.location = location;
	}

}
