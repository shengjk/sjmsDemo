package xmht.jvm.load.hotswap;

public class Hot {
    public Hot() {
    }
    
    public void hot(){
        System.out.println(" version 1 : "+this.getClass().getClassLoader());
    }
    
    public void hot(String z){
        System.out.println(" version "+z+" : "+this.getClass().getClassLoader());
    }
}