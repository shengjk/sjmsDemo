package xmht.javabase.classinfofanshe;

/**
 * Created by shengjk1 on 2018/4/13
 */
class Building{}
class House extends Building{}

public class ClassCasts {
	public static void main(String[] args) {
		Building building=new House();
		Class<House> houseClass = House.class;
		House house = houseClass.cast(building);
		house=(House)building;//or just do it
	}
}
