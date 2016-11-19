
/**
 * @author Alin Arhip
 *
 */
public class Sphere extends ObjFunction {

	@Override
	public double call(double x, double y) {
		return x * x + y * y;
	}

}
