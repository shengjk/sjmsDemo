package xmht.javabase.java4;

/**
 * Created by shengjk1 on 2017/11/13
 */
public enum  SimpleEnumUse {
	NOT,MILD,MEDIUM,HOT,FLAMING
}

class Sim{

	SimpleEnumUse degree;
	public void describe(){
		System.out.println("this burrito is ");
		switch (degree){
			case HOT:
				System.out.println("Hot");
				break;
		}
	}
	
	public static void main(String[] args) {
		SimpleEnumUse simpleEnumUse= SimpleEnumUse.FLAMING;
		System.out.println(simpleEnumUse);
	}
}
