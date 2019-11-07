package xmht.javabase.effictjava.chapter02.test02;

public class Outer1 {
    private int size;
    public class Inner {
        private int a;
        
        public void dostuff() {
            size++;
        }
    }
    public void testTheInner() {
        Inner in = new Inner();
        in.dostuff();
    }
    
    private void test(Inner inner){
        System.out.println(inner.a);
    }
    private void test(Outer1 outer1){
        boolean b = this.size == outer1.getSize();
        boolean b1 = this.size == outer1.size;
        System.out.println(outer1.size);
    }
    
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    
    public static void main(String[] args) {
        int size = new Outer1().size;
    }
}