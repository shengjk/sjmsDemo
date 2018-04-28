package xmht.jvm.load.hotswap;

import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) throws Exception {
        int size = args.length > 0 ? Integer.valueOf(args[0]) : 1_000_000;
        Class<?> clz = Class.forName("xmht.jvm.load.hotswap.Hot");
        Object o = clz.newInstance();
        Method m = clz.getMethod("hot", String.class);
    
//        while (true){
//            App.class.newInstance();
//        }
        
        for(int i=0; i<500; i++) {
//            for(int j=0; j<size; j++){
               m.invoke(o, "hello"+i);
//            }
            Thread.sleep(50);
        }
        System.out.println("---finish loop----");
        Thread.sleep(20_000);
    }
}