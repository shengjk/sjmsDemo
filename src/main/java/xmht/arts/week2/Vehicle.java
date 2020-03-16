package xmht.arts.week2;

public class Vehicle implements CustomCloneable {
	private final String model;
	
	public Vehicle(String model) {
		this.model = model;
	}
	
	@Override
	//返回子类，避免了强制转换
	public Vehicle customClone() {
		return new Vehicle(this.model);
	}
	
	public String getModel() {
		return this.model;
	}
	
	
	public static void main(String[] args) {
		Vehicle originalVehicle = new Vehicle("Corvette");
		Vehicle clonedVehicle = originalVehicle.customClone();
		System.out.println(clonedVehicle.getModel());
	}
	
	/**
	 * 1. 父类是 void 的话，子类也是void
	 * 2. 父类为基本类型的haunt，子类也必须为相同的基本类型
	 */
}