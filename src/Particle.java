
/**
 * @author Alin Arhip
 *
 */
public class Particle {
	private Velocity velocity;
	private Location location;

	public Particle() {
	}

	public Particle(Velocity velocity, Location location) {
		this.velocity = velocity;
		this.location = location;
	}

	public Velocity getVelocity() {
		return velocity;
	}

	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}
