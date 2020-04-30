package jvm.sgg.chapter01;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author shengjk1
 * @date 2020/4/27
 */
public class ClassLoaderTest1 {
	public static void main(String[] args) {
		System.out.println("BootstrapClassLoader");
		URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
		for (URL urL : urLs) {
			System.out.println(urL.toExternalForm());
		}
		
		System.out.println("扩展类");
		String extDirs = System.getProperty("java.ext.dirs");
		for (String path : extDirs.split(":")) {
			System.out.println(path);
		}
		
	}
}
