package xmht.jvm.load;

import java.io.File;
import java.net.URL;
import java.util.StringTokenizer;

/**
 * BootStrap ClassLoader：称为启动类加载器，是Java类加载层次中最顶层的类加载器，
 * 负责加载JDK中的核心类库，如：rt.jar、resources.jar、charsets.jar等
 *
 */
public class BootStrapClassLoader {
    public static void main(String[] args) {
        /*
         * 罗列当前程序所加载的JDK
         */
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        //也可以通过sun.boot.class.path环境变了获取
        System.out.println(System.getProperty("sun.boot.class.path"));
    
    
        System.out.println("java.ext.dirs===========================================");
        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader extClassLoader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println(extClassLoader.getClass());
    
        
        System.out.println("java.class.path===========================================");
        System.out.println(System.getProperty("java.class.path"));
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(appClassLoader.getClass());
	
		System.out.println("classLoader=========================================");
		ClassLoader classLoader = BootStrapClassLoader.class.getClassLoader();
		while (classLoader!=null){
			System.out.println(classLoader.toString());
			classLoader=classLoader.getParent();
		}
		System.out.println("++++++++++");
		System.out.println(classLoader);
	
	
	
	
	
	
		String var0 = System.getProperty("java.ext.dirs");
		File[] var1;
		if (var0 != null) {
			StringTokenizer var2 = new StringTokenizer(var0, File.pathSeparator);
			System.out.println(var2.nextToken()+"==========");
			int var3 = var2.countTokens();
			var1 = new File[var3];
		
			for(int var4 = 0; var4 < var3; ++var4) {
				var1[var4] = new File(var2.nextToken());
			}
		} else {
			var1 = new File[0];
		}
	
		for (File f:var1) {
			System.out.println(f.getAbsolutePath());
		}
		
	}
}