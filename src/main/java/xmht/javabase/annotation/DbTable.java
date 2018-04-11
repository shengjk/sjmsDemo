package xmht.javabase.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by shengjk1 on 2018/4/11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DbTable {
	public String name() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Constraints {
	boolean primaryKey() default false;
	
	boolean allowNull() default true;
	
	boolean unique() default false;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLString {
	int id() default 0;
	
	int value() default 0;
	
	String name() default "";
	
	Constraints constraints() default @Constraints;
}


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface SQLInteger {
	String name() default "";
	
	Constraints constraints() default @Constraints;
}


@interface Uniqueness {
	Constraints constraints() default @Constraints(unique = true);
}


//@DbTable(name = "哈哈哈哈")
@DbTable
class Member {
	/*
	如果程序员的注解中定义了名为value的元素，并且在应用改注解的时候，如果该元素是唯一需要赋值的一个元素，那么此时唔需要使用名=值对的这种语法，而只需要
	在括号内给出value元素所需的值即可
	 */
	@SQLString(value = 50, name = "5000")
//	@SQLInteger
	String lasttName;
	@SQLInteger
	Integer age;
	
	@SQLString(30)//只对value的字段进行赋值
	String firstName;
	@SQLString(id = 30, constraints = @Constraints(primaryKey = true))
	String handle;//
	static int memberCount;
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLasttName() {
		return lasttName;
	}
	
	public void setLasttName(String lasttName) {
		this.lasttName = lasttName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getHandle() {
		return handle;
	}
	
	public void setHandle(String handle) {
		this.handle = handle;
	}
	
	public static int getMemberCount() {
		return memberCount;
	}
	
	public static void setMemberCount(int memberCount) {
		Member.memberCount = memberCount;
	}
}


//将上面的Member转化为建表语句
class TableCreator {
	public static void main(String[] args) throws ClassNotFoundException {
//		if (args.length < 1) {
//			System.out.println("arguments :annotated classes");
//			System.exit(0);
//		}
		args = new String[]{"xmht.javabase.annotation.Member"};
		for (String className : args) {
			Class<?> cl = Class.forName(className);
			DbTable dbTable = cl.getAnnotation(DbTable.class);
			if (dbTable == null) {
				System.out.println("No DBTable annotations in class " + className);
				continue;
			}
			
			String tableName = dbTable.name();
			if (tableName.length() < 1) {
//				tableName = cl.getName().toUpperCase();
				System.out.println(cl.getName());//xmht.javabase.annotation.Member
				System.out.println(cl.getCanonicalName());//xmht.javabase.annotation.Member
				System.out.println(cl.getSimpleName());//Member
				System.out.println(cl.getTypeName());//xmht.javabase.annotation.Member
				tableName = cl.getSimpleName().toUpperCase();
			}
			
			ArrayList<String> columnDefs = new ArrayList<>();
			for (Field field : cl.getDeclaredFields()) {
				String columnName = null;
				Annotation[] anns = field.getDeclaredAnnotations();////每一个field只有一个注解，所以anns[0]
				if (anns.length < 1) {
					continue; //not a bd table column
				}
				
				if (anns[0] instanceof SQLInteger) {
					SQLInteger sInt = (SQLInteger) anns[0];
					//use filed name if name not specified
					if (sInt.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sInt.name();
					}
					columnDefs.add(columnName + " INT " + getConstraints(sInt.constraints()));
				}
				
				
				if (anns[0] instanceof SQLString) {
					SQLString sString = (SQLString) anns[0];
					if (sString.name().length() < 1) {
						columnName = field.getName().toUpperCase();
					} else {
						columnName = sString.name();
					}
					
					columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
				}

//				StringBuilder createCommand=new StringBuilder(
//						"CREATE TABLE "+tableName +"("
//				);
//
//				for (String columndef:columnDefs) {
//					createCommand.append("\n "+columndef+",");
//				}
//				String tableCreate=createCommand.substring(0,createCommand.length()-1)+");";
//				System.out.println("Table cteation sql for "+className +" is : \n" +tableCreate);
			}
			
			StringBuilder createCommand = new StringBuilder(
					"CREATE TABLE " + tableName + "("
			);
			
			for (String columndef : columnDefs) {
				createCommand.append("\n " + columndef + ",");
			}
			String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
			System.out.println("Table cteation sql for " + className + " is : \n" + tableCreate);
		}
	}
	
	private static String getConstraints(Constraints con) {
		String constraints = "";
		if (!con.allowNull()) {
			constraints += " NOT NULL";
		}
		if (con.primaryKey()) {
			constraints += " PRIMARY KEY";
		}
		if (con.unique()) {
			constraints += " UNIQUE";
		}
		return constraints;
	}
}

class DbtableTracker {
	//利用反射读取注解的内容
	public static void trackUseCases(Class<?> cl) {
		/*
		@xmht.javabase.annotation.DbTable(name=哈哈哈哈)
@xmht.javabase.annotation.DbTable(name=哈哈哈哈)
======= xmht.javabase.annotation.Member
		 */
		Annotation[] annotations = cl.getDeclaredAnnotations();
		System.out.println(annotations[0]);
		Annotation[] annotations1 = cl.getAnnotations();
		for (Annotation annotations2 : annotations1) {
			System.out.println(annotations2);
		}
		String canonicalName = cl.getCanonicalName();
		System.out.println("======= " + canonicalName);
		
		
		for (Field m : cl.getDeclaredFields()) {
			SQLString uc = m.getAnnotation(SQLString.class);
			if (uc != null) {
				System.out.println(uc.id());
			}
		}
	}
	
	public static void main(String[] args) {
		trackUseCases(Member.class);
	}
}