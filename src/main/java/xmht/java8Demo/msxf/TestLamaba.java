package msxf;

import java.util.Arrays;
import java.util.List;

/**
 * Created by landscape.
 */
public class TestLamaba {
	public static void main(String[] args) throws InterruptedException {
		Thread t =new Thread(()->{
			System.out.println("lambda ");
		});
		t.start();
		t.join();
		System.out.println("主线程");
		
		String[] atp={"Rafael Nadal","Novak"};
		List<String> pals= Arrays.asList(atp);

		for (String pal:pals){
			System.out.println(pal +":");
		}

		System.out.println("=================");

		pals.forEach(System.out::println);

		System.out.println("******************");

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("run....");
			}
		}).start();

		new Thread(()->System.out.println("run...")).start();
//        BiFunction
		
	}
}
