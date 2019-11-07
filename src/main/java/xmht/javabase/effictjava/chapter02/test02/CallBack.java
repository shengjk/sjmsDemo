package xmht.javabase.effictjava.chapter02.test02;

public class CallBack {

    public static void main(String[] args) {
        CallBack callBack = new CallBack();
        callBack.toDoSomethings(100, new CallBackInterface() {
            @Override
            public void execute() {
                System.out.println("我的请求处理成功了");
            }
        });

    }

    public void toDoSomethings(int a, CallBackInterface callBackInterface) {
        long start = System.currentTimeMillis();
        //此处回调函数感觉用的甚是精妙，之后的代码中也应该试着取用回调函数来解决问题，像百川的redis删除可以试着改成回调函数的形式
        if (a > 100) {
            callBackInterface.execute();
        } else {
            System.out.println("a < 100 不需要执行回调方法");
        }
        long end = System.currentTimeMillis();
        System.out.println("该接口回调时间 : " + (end - start));
    }
}

 interface CallBackInterface {

    void execute();
}
