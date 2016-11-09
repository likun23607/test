package test09Process;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFuture {

	public static void main(String[] args) {
	    Callable<HashMap<String,String>> callable = new Callable<HashMap<String,String>>() {

			@Override
			public HashMap<String, String> call() throws Exception {
				// TODO Auto-generated method stub
				Map<String,String> m=new HashMap<String,String>();
				m.put("1", "likun");
				m.put("2", "zhangsan");
				return (HashMap<String, String>) m;
			}
           
        };
        FutureTask<HashMap<String,String>> future = new FutureTask<HashMap<String,String>>(callable);
        new Thread(future).start();
        try {
        	System.out.println(future.get().get("1"));
            Thread.sleep(5000);// 可能做一些事情
        	System.out.println(future.get().get("2"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
	}

}
