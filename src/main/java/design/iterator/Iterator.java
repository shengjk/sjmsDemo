package design.iterator;

/**
 * @author shengjk1
 * @date 2020/11/11
 */
public interface Iterator {
	boolean hasNext();
	
	MenuItem next();
}
