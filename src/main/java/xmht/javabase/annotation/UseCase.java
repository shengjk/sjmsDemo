package xmht.javabase.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shengjk1 on 2018/4/11
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	public   int id();
	public String descripetion() default "no dscription";
}




@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase1 {
	public int id() default -1;//来表示某个元素不存在 成员变量
	public String descripetion() default "";
}



//使用注解
class PasswordUtios{
	@UseCase(id =47,descripetion = "passwords must contain at least one numeric")
	public boolean validatePassword(String password){
		return password.matches("\\w*\\d\\w*");
	}
	
	@UseCase(id=48,descripetion = "aaaaa")
	public String encryptPassword(String password){
		return new StringBuilder(password).reverse().toString();
	}
	
	@UseCase(id = 49,descripetion = "new passWords can't equal previously used ones")
	public boolean checkForNewPassword(List<String> prePassWordl, String password){
		return !prePassWordl.contains(password);
	}
}



class UseCaseTracker1 {
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
