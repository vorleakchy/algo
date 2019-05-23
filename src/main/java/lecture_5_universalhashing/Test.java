package lecture_5_universalhashing;

public class Test {
	static String n = System.getProperty("line.separator");
	static void collisionsUniversal() {
		System.out.println("Collisions with universal hashing: "+n+n);
		SepChainHashTable table = null;  
		int tablesize = 169;
		HashFunction h = null;
		for(int round = 0; round < 50; ++round ){
			h = new UniversalHashFunction(Record.MAX_EMPLOYEE_NUM);
			System.out.println(h);
			table = new SepChainHashTable(tablesize,true);
			//this ensures universal hashing is being used
			table.setHashFunction(h);
			
			int nextNum = 0;
			for(int i = 0; i < 500; ++i){
				//this produces numbers between 100,000 and 1,000,000
				nextNum = (RandomNumbers.getRandomInt(100000,1000000) /13)*13;
				
				
				table.put(nextNum,new Record(new AddressInfo(),new WorkInfo(),nextNum));
			}
			//test num collisions on an insertion
			//System.out.println("Test for round "+round);
			nextNum = (RandomNumbers.getRandomInt(100000,1000000)/13)*13;
			
			table.putDisplayCollisions(nextNum,new Record(new AddressInfo(),new WorkInfo(),nextNum));
		}
		System.out.println("Collisions record: ");
		System.out.println(table.collisionCount);		
		
		
	}
	static void collisionsNotUniversal() {
		System.out.println("Collisions not using universal hashing: "+n+n);
		System.out.println("500/13 = " + 500/13);
		System.out.print("Multiples of 13: " + "0, 13, 26, 39, 52, 65, 78, 91, 104, 117, 130, 143, 156\n\n");
		SepChainHashTable table = null;  
		int tablesize = 169;
		HashFunction h = null;
		for(int round = 0; round < 50; ++round ){
			table = new SepChainHashTable(tablesize,true);
			int nextNum = 0;
			for(int i = 0; i < 500; ++i){
				//this produces numbers between 100,000 and 1,000,000
				nextNum = (RandomNumbers.getRandomInt(100000,1000000) /13)*13;
				
				
				table.put(nextNum,new Record(new AddressInfo(),new WorkInfo(),nextNum));
			}
			//test num collisions on an insertion
			//System.out.println("Test for round "+round);
			nextNum = (RandomNumbers.getRandomInt(100000,1000000)/13)*13;
			
			table.putDisplayCollisions(nextNum,new Record(new AddressInfo(),new WorkInfo(),nextNum));
		}
		//System.out.println("Collisions record: ");
		//System.out.println(table.collisionCount);			
		
		
	}
	public static void main(String[] args) {
//		for(int i = 0; i <= 13; ++i) {
//			System.out.print(13 * i + ", ");
//		}
		collisionsNotUniversal();
		
		//collisionsUniversal();
	}
}
