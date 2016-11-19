
/**
 * @author Alin Arhip
 *
 */
abstract class ObjFunction {

	public abstract double call(double x, double y);

	@Override
	public String toString() {
		return this.getClass().getName();
	}
}
