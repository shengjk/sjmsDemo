package xmht.javabase.jtnbl;

public class OutClass1 {
	public static class innerClass{
        public innerClass(){
            System.out.println("innerClass");
        }
    }
    public static void main(String[] args) 
    { 
        //outClass a = new outClass();
        innerClass b = new innerClass();
        innerClass c = new innerClass();
        
    }
    
}