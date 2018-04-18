package xmht.javabase.classinfofanshe;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

/**
 * Created by shengjk1 on 2018/4/17
 */
//懒加载
interface ILoadFile{
	String load();
}

//真实实现类
public class LazyLoadFile implements ILoadFile{
	String fileContent="";
	
	public LazyLoadFile() throws InterruptedException {
		
		TimeUnit.MILLISECONDS.sleep(3*1000);
		fileContent="file contents...";
	}
	
	@Override
	public String load() {
		System.out.println(fileContent);
		return fileContent;
	}
}

//代理类
class loadFileHander implements InvocationHandler{
	ILoadFile loadFile=null;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (loadFile==null){
			loadFile=new LazyLoadFile();
		}
		return loadFile.load();
//		return method.invoke(proxy,args);
	}
	
	
	public static void main(String[] args) {
		
		ILoadFile loadFile = (ILoadFile) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
				new Class[]{ILoadFile.class},
				new loadFileHander());
		System.out.println("===============");
		loadFile.load();
	}
}