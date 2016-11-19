
/**
 * @author Alin Arhip
 *
 */
public class Rastrigin extends ObjFunction implements Constants {

	@Override
	public double call(double x, double y) {
		return 10 * 2 + (x * x - 10 * Math.cos(2 * PI * x)) + (y * y - 10 * Math.cos(2 * PI * y));
	}

}
