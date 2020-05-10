package xmht.jvm.bytecod.javassit;

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
		//ClassPool is a hash table of CtClass objects, which uses the class names as keys
		//to correctly compile such a method call, the ClassPool must contain all the instances of CtClass all the time of program execution.
		ClassPool pool = ClassPool.getDefault();
		try {
			CtClass ct = pool.getCtClass("xmht.jvm.bytecod.javassit.Point");
			CtMethod m = ct.getDeclaredMethod("move");
			m.insertBefore("{ System.out.print(\"dx:\"+$1); System.out.println(\"dy:\"+$2);}");
			m.insertAfter("{System.out.print(this.x); System.out.println(this.y);}");
			
			//If a CtClass object is converted into a class file by writeFile(), toClass(), or toBytecode(), Javassist freezes that CtClass object. Further modifications of that CtClass object are not permitted
//			ct.writeFile("/Users/iss/sourceCode/spark/sjmsDemo/src/main/java/xmht/jvm/bytecod/javassit/xmht/jvm/javassit");
//			ct.writeFile();
			//为了仍然可以继续修改ctclass文件
//			ct.defrost();
			//避免OOM，明确去除某个 ctclass from ClassPool,之后讲不可调用这个class的所有方法
//			ct.detach();
			//通过反射调用方法，查看结果
			Class pc = ct.toClass();
			Method move = pc.getMethod("move", int.class, int.class);
			Constructor<?> con = pc.getConstructor(int.class, int.class);
			for (int i = 0; i < 1; i++) {
				move.invoke(con.newInstance(1, 2), 1, 2);
			}
			
			//defining a new class
			CtClass point2 = pool.makeClass("Point2", ct);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
