package msxf;

import java.time.ZoneId;

/**
 * Created by shengjk1 on 2016/12/5.
 */
public class OtherDemo {
	public static void main(String[] args) {
		
		//string
		String joined=String.join("/","user","local","bin");
		System.out.println(joined);
		
		String ids=String.join(",", ZoneId.getAvailableZoneIds());
		System.out.println(ids);
		
		//数字类
		
		
	}
}
