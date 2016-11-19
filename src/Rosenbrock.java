
/**
 * @author Alin Arhip
 *
 */
public class Rosenbrock extends ObjFunction {

	@Override
	public double call(double x, double y) {
		return Math.pow(1 - x, 2) + 100 * Math.pow(y - Math.pow(x, 2), 2);
	}

}
