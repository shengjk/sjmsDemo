package xmht.javabase.enumdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

import static xmht.javabase.enumdemo.AlarmPoints.OFFICE2;
import static xmht.javabase.enumdemo.AlarmPoints.OFFICE3;

/**
 * Created by shengjk1 on 2017/11/23
 */
enum Shrubbery {
	GROUND, CRAWLING, HANGING
}

public class EnumClass {
	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			System.out.println(s);
		}
		for (String s : "HANGING CRAWLING GROUND".split(" ")) {
			Shrubbery shrubbery = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrubbery);
			System.out.println(shrubbery.getDeclaringClass().getName());
			System.out.println(shrubbery.getClass().getName());
		}
	}
}

//枚举类不一般情况下应该是不提供set方法的
enum CompanyEnum {
	SF("顺丰速运", 1001), YTO("圆通速递", 1002), STO("申通物流", 1003), YD("韵达快运", 1004), YZPY("中国邮政", 1005);
	private String company;
	private int code;
	
	private CompanyEnum(String company, int code) {
		this.company = company;
		this.code = code;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public static void main(String[] args) {
		System.out.println(CompanyEnum.SF.getCode());
		System.out.println(CompanyEnum.SF.getCompany());
		CompanyEnum.SF.setCode(111111);
		System.out.println(CompanyEnum.SF.getCode());
	}
}

enum GenderEnum {
	MAN(0),
	WOMEN(1),
	UNKNOWN(2);
	private int code;
	
	GenderEnum(int code) {
		this.code = code;
	}
}

enum SpaceSHip {
	SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
	
	@Override
	public String toString() {
		String id = name();
		System.out.println(ordinal());
		return id;
	}
	
	public static void main(String[] args) {
		for (SpaceSHip s : values()) {
			System.out.println(s);
		}
	}
}

enum Explore {HERE, THERE}

class Reflection {
	public static Set<String> analyze(Class<?> enumClass) {
		for (Type t : enumClass.getGenericInterfaces()) {
			System.out.println(t);
		}
		Set<String> methods = new TreeSet<>();
		for (Method m : enumClass.getMethods()) {
			methods.add(m.getName());
			System.out.println(m.getName());
		}
//		System.out.println(methods);
		return methods;
	}
	
	public static void main(String[] args) {
		Set<String> exploreMethods = analyze(Explore.class);
		Set<String> enumMethods = analyze(Enum.class);
		
		System.out.println(enumMethods.containsAll(exploreMethods));
		System.out.println(exploreMethods.removeAll(enumMethods));
	}
}

enum CartoonCharacter implements Gengrator<CartoonCharacter> {
	SLEEP, SPANKY, PUNCHY, SILLY, BOUNCY;
	private Random random = new Random(47);
	
	public CartoonCharacter next() {
		return values()[random.nextInt(values().length)];
	}
}


/**
 * 对于enum而言，实现接口是使其子类化的唯一办法
 */
interface Food {
	enum Appetizer implements Food {
		SALAD, SOUP;
	}
	
	enum MainCourse implements Food {
		LASAGNE, BURRITO, PAD_THAI;
	}
	
	enum Dessert implements Food {
		TIRAMISU, GELATO;
	}
	
	enum Coffee implements Food {
		BLACK_COFFEE, DECAF_COFFEE;
	}
}
class TypeOfFood{
	public static void main(String[] args) {
		Food food=Food.Appetizer.SALAD;
		food= Food.MainCourse.BURRITO;
	}
}

enum AlarmPoints{
	STAIR1,STAIR2,LOBBY,OFFICE1,OFFICE2,OFFICE3,OFFICE5,OFFICE4,
}
class EnumSets{
	public static void main(String[] args) {
		EnumSet<AlarmPoints> enumSet=EnumSet.noneOf(AlarmPoints.class);
		enumSet.add(AlarmPoints.STAIR1);
		System.out.println(enumSet);
		enumSet.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2));
		System.out.println(enumSet);
		enumSet=EnumSet.allOf(AlarmPoints.class);
		System.out.println(enumSet);
		enumSet.removeAll(EnumSet.range(OFFICE2,OFFICE3));
		System.out.println(enumSet);
	}
}