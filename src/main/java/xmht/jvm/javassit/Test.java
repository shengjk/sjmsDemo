package xmht.jvm.javassit;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author shengjk1
 * @date 2019/10/15
 */
public class Test {
	public static void main(String[] args) {
		ClassPool pool=ClassPool.getDefault();
		try {
			CtClass ct=pool.getCtClass("xmht.jvm.javassit.Point");
			CtMethod m=ct.getDeclaredMethod("move");
			m.insertBefore("{ System.out.print(\"dx:\"+$1); System.out.println(\"dy:\"+$2);}");
			m.insertAfter("{System.out.println(this.x); System.out.println(this.y);}");
			
			ct.writeFile("/Users/iss/sourceCode/spark/sjmsDemo/src/main/java/xmht/jvm/javassit");
			//通过反射调用方法，查看结果
			Class pc=ct.toClass();
			Method move= pc.getMethod("move",new Class[]{int.class,int.class});
			Constructor<?> con=pc.getConstructor(new Class[]{int.class,int.class});
			for (int i = 0; i < 100; i++) {
				move.invoke(con.newInstance(1,2),1,2);
			}
		}catch (Exception e){
			System.out.println(e);
		}
	}
}
