package xmht.reflect;

import java.lang.reflect.Method;

public class ReflectCase {
 
    public static void main(String[] args) throws Exception {
        while (true){
            Proxy target = new Proxy();
            Method method = Proxy.class.getDeclaredMethod("run");
            method.invoke(target);
        }
       
    }
 
    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }
}