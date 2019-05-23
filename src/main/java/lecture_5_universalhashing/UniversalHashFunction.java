package lecture_5_universalhashing;

import java.math.BigInteger;

/**
 * Supports universal hashing. 
 *
 */
public class UniversalHashFunction extends HashFunction {
	private int coeffA = 0;
	private int coeffB = 0;
	private int nextPrime = 0; 
	private BigInteger a = null;
	private BigInteger b = null;
	private BigInteger prime = null;
	private static final int DEFAULT_MAX = 10000000;
	/* maxSize of an input integer -- objects are transformed
	 * into numbers in the range 0..maxSize */
	private int maxSize;	
	public UniversalHashFunction() {
		this(DEFAULT_MAX);
	}
	public UniversalHashFunction(int maxSize) {
		super();
		this.maxSize = maxSize;
		nextPrime = Primes.nextPrime(maxSize+1);
		//a should not be 0
		coeffA = RandomNumbers.getRandomInt(1,nextPrime-1);
		coeffB = RandomNumbers.getRandomInt(0,nextPrime-1);
		a = new BigInteger(Integer.toString(coeffA));
		b = new BigInteger(Integer.toString(coeffB));		
		prime = new BigInteger(Integer.toString(nextPrime));			
	}
	public int hash(Object ob) {
		int num = hashIntoRange(ob);
		BigInteger val = BigInteger.valueOf(num);
		BigInteger result = a.multiply(val).add(b).mod(prime);
		//System.out.println("BigInteger hash: "+result);
		int hashVal = result.intValue();
		//System.out.println("...small int hash code = "+retVal);
		return hashVal; 		
	}
	
	//use ob's hash function and math operations
	//to squeeze into the range 0..maxSize
	private int hashIntoRange(Object ob){
		int val = ob.hashCode();
		val = Math.abs(val);
		val = val % maxSize+1;
		return val;
	}
	public String toString() {
		String ret = "h(x) = ";
		ret += a.intValue()+"x + "+b.intValue();
		return ret;
	}
	
}
