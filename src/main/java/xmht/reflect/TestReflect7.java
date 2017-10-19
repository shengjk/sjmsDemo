package xmht.reflect;

import java.lang.reflect.Field;

//    通过反射机制操作某个类的属性
public class TestReflect7{
	private String proprety = null;
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("xmht.reflect.TestReflect7");
        Object obj = clazz.newInstance();
        // 可以直接对 private 的属性赋值
        Field field = clazz.getDeclaredField("proprety");
        field.setAccessible(true);
        field.set(obj, "Java反射机制");
        System.out.println(field.get(obj));
        System.out.println(((TestReflect7)obj).getProprety());
    }
    
    public String getProprety() {
        return proprety;
    }
    
    public void setProprety(String proprety) {
        this.proprety = proprety;
    }
}