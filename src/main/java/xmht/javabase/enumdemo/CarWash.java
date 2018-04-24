package xmht.javabase.enumdemo;

import java.util.EnumSet;

/**
 * Created by shengjk1 on 2018/4/24
 */
/*
每个顾客在洗车时，都有一个选择菜单，每选择对应一个不同的动作，可以将一个常量相关的方法关联到一个选择上，再使用一个EnumSet来保存客户的选择
与使用匿名内部类相比较，定义常量相关的方法的语法更高效、简洁
 */
public class CarWash {
	public enum Cycle {
		UNDERBODY {
			@Override
			void action() {
				System.out.println("Spraying the underbody");
			}
		},
		WHEELWASH {
			@Override
			void action() {
				System.out.println("Washing the wheels");
			}
		},
		PREWASH {
			@Override
			void action() {
				System.out.println("Loosening the dirt");
			}
			
		},
		BASIC {
			@Override
			void action() {
				System.out.println("THe basic wash");
			}
		},
		RINSE {
			@Override
			void action() {
				System.out.println("rinsing");
			}
			
		};
		
		abstract void action();
	}
	
	EnumSet<Cycle> cycles = EnumSet.of(Cycle.BASIC, Cycle.RINSE);
	
	public void add(Cycle cycle) {
		cycles.add(cycle);
	}
	
	public void washCar(){
		for (Cycle c:cycles){
			c.action();
		}
	}
	
	@Override
	public String toString() {
		return cycles.toString();
	}
	
	
	public static void main(String[] args) {
		CarWash wash=new CarWash();
		System.out.println(wash);
		wash.washCar();
		wash.add(Cycle.PREWASH);
	}
}
