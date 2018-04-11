package xmht.javabase.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shengjk1 on 2018/4/11
 */

//注解处理器
public class UseCaseTracker {
	//利用反射读取注解的内容
	public static  void trackUseCases(List<Integer> useCase,Class<?> cl){
		for (Method m:cl.getDeclaredMethods() ) {
			UseCase uc=m.getAnnotation(UseCase.class);
			if (uc!=null){
				System.out.println(uc.id()+" "+uc.descripetion());
				useCase.remove(new Integer(uc.id()));
			}
		}
		for (int i : useCase) {
			System.out.println("Warning:Missing use case-"+i);
		}
	}
	
	public static void main(String[] args) {
		List<Integer> useCase=new ArrayList<>();
		Collections.addAll(useCase,47,48,49,50);
		trackUseCases(useCase,PasswordUtios.class);
	}
}
