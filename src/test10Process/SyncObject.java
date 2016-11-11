package test10Process;

/**
 * Created by Administrator on 2016/11/11.
 */
public class SyncObject {
    public static void main(String[] args)  {
        final DualSynch ds=new DualSynch();
        new Thread(){
            @Override
            public void run() {
                    ds.f();
            }
        }.start();
        ds.g();
    }
}
