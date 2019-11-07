package xmht.javabase.effictjava.chapter02.test01;

/**
 * @author shengjk1
 * @date 2019-05-13
 */
public class Test {
	public static void main(String[] args) {
		// Providers would execute these lines
		Services.registerDefaultProvider(DEFAULT_PROVIDER);
		Services.registerProvider("comp", COMP_PROVIDER);
		Services.registerProvider("armed", ARMED_PROVIDER);
		
		// Clients would execute these lines
		IService s1 = Services.newInstance();
		IService s2 = Services.newInstance("comp");
		IService s3 = Services.newInstance("armed");
		System.out.printf("%s, %s, %s%n", s1, s2, s3);
	}
	
	private static Provider DEFAULT_PROVIDER=new Provider() {
		@Override
		public IService newService() {
			return new IService() {
				@Override
				public String toString() {
					return "Default service";
				}
			};
		}
	};
	
	private static Provider COMP_PROVIDER = new Provider() {
		@Override
		public IService newService() {
			return new IService() {
				@Override
				public String toString() {
					return "Complementary service";
				}
			};
		}
	};
	
	private static Provider ARMED_PROVIDER = new Provider() {
		@Override
		public IService newService() {
			return new IService() {
				@Override
				public String toString() {
					return "Armed service";
				}
			};
		}
	};
}
