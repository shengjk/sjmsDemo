package xmht.javabase.classinfofanshe;

/**
 * Created by shengjk1 on 2018/4/18
 */

class TableDAO {
	public void create() {
		System.out.println("create() is running !");
	}
	
	public void query() {
		System.out.println("query() is running !");
	}
	
	public void update() {
		System.out.println("update() is running !");
	}
	
	public void delete() {
		System.out.println("delete() is running !");
	}
}

class TableDAOFactory {
	private static final TableDAO tDao = new TableDAO();
	
	public static TableDAO getInstance() {
		return tDao;
	}
}


public class CglibProxyClient1 {
	public static void main(String[] args) {
		TableDAO tableDao = TableDAOFactory.getInstance();
		doMethod(tableDao);
	}
	
	public static void doMethod(TableDAO dao) {
		dao.create();
		dao.query();
		dao.update();
		dao.delete();
	}
}
