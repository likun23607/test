package test10Process;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/11/11.
 */
public class Accesor implements Runnable{
    private final int id;
    public Accesor(int idn){
        id=idn;
    }
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();

        }
    }

    @Override
    public String toString() {
        return "#"+id+": "+ThreadLocalVariableHolder.get();
    }
}
