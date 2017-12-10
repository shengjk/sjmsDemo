package xmht.javabase;

/**
 * Created by shengjk1 on 2017/11/10
 */
class Chair {
	static boolean gcrun = false;
	static boolean f = false;
	static int created = 0;
	static int finalized = 0;
	int i;
	
	public Chair() {
		i = ++created;
		if (created == 47) {
			System.out.println("created 47");
		}
	}
	
	protected void finalize() {
		if (!gcrun) {
			gcrun = true;
			System.out.println(
					"Beginning to finalize after " +
							created + " Chairs have been created");
		}
		
		if (i == 47) {
			System.out.println(
					"Fi nal i zi ng Chai r #47, " +
							"Setti ng fl ag to stop Chai r creati on");
			f = true;
		}
		
		finalized++;
		if (finalized >= created)
			System.out.println(
					"All " + finalized + "finalized");
	}
}

public class Garbage {
	public static void main(String[] args) {
//		if (args.length == 0) {
//			System.err.println("Usage: \n" +
//					"java Garbage before\n or:\n" +
//					"java Garbage after");
//			return;
//		}
		while (!Chair.f) {
			new Chair();
			new String("To take up space");
		}
		System.out.println(
				"After all Chairs have been created:\n" + "total created = " + Chair.created +
						", total finalized=" + Chair.finalized);
//		if (args[0].equals("before")) {
//			System.out.println(" g c ( ) : ");
//			System.gc();
//			System.out.println(" r u n F i n a l i z a t i o n ( ) : ");
//			System.runFinalization();
//		}
//		System.out.println(" b y e ! ");
//		if (args[0].equals(" af t er "))
//			System.runFinalizersOnExit(true);
	}
}