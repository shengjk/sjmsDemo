package xmht.javabase.jtnbl;

public class OutClass {
    public class innerClass{
        public innerClass(){
            System.out.println("innerClass");
        }
    }
    public static void main(String[] args)
    {
        OutClass a = new OutClass();
        innerClass b = a.new innerClass();
        innerClass c = a.new innerClass();
        
    }
    
}