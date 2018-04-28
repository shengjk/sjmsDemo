package xmht.jvm.load;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by shengjk1 on 2018/4/27
 */
public class MyClassLoader extends ClassLoader {
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String fileName=name.substring(name.lastIndexOf(".")+1)+".class";
		System.out.println(fileName);
		byte[] bytes = loadClassData("/Users/iss/sourceCode/gitProject/test/test1/target/classes/iss/" + fileName);
		
		return defineClass(name,bytes,0,bytes.length);
	}
	
	public byte[] loadClassData(String name) {
		FileInputStream fileInput = null;
		ByteArrayOutputStream bytesOutput = null;
		try {
			fileInput = new FileInputStream(new File(name));
			bytesOutput = new ByteArrayOutputStream();
			int b = 0;
			while ((b = fileInput.read()) != -1) {
				bytesOutput.write(b);
			}
			return bytesOutput.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fileInput != null)
					fileInput.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	public static void main(String[] args){
		MyClassLoader myClassLoader = new MyClassLoader();
		try {
			Class<? extends Object> testClass = myClassLoader.loadClass("iss.Test3");
			Object obj = testClass.newInstance();
			System.out.println(obj.getClass().getClassLoader().toString());
			
			ClassLoader parent = myClassLoader.getParent();
			while (parent!=null){
				System.out.println("=================== "+parent);
				parent=parent.getParent();
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
