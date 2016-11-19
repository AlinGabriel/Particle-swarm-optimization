
/**
 * @author Alin Arhip
 *
 */
public class Grienwank extends ObjFunction {

	@Override
	public double call(double x, double y) {
		return 1 + 1 / 4000 * x * x + 1 / 4000 * y * y - Math.cos(x) * Math.cos(1 / 2 * y * Math.sqrt(2));
	}

}
