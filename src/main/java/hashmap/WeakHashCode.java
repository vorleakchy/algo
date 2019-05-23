package hashmap;

/** This is an example of a class in which
 *  hashCode has been overridden in the 
 *  worst possible way
 */
public class WeakHashCode {
	private String x = "" + Math.random();
	public String getX() {
		return x;
	}
	@Override
	public int hashCode() {
		return 7;
	}
}
