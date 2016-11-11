package test10Process;

/**
 * Created by Administrator on 2016/11/11.
 */
public class DualSynch {
    private Object syncObject=new Object();
    public synchronized void f()   {
        for (int i=0;i<5;i++) {
            System.out.println("f()" + Thread.currentThread());
            Thread.yield();
        }
    }
    public void g()   {
        synchronized (syncObject){
            for (int i=0;i<5;i++){
                System.out.println("g()"+Thread.currentThread());
                Thread.yield();
            }
        }
    }
}
