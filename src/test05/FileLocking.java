package test05;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLocking {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos=new FileOutputStream("file.txt");
		FileLock fl=fos.getChannel().tryLock();
		if(fl!=null){
			System.out.println("Lock File");
			TimeUnit.MILLISECONDS.sleep(1000);
			fl.release();
			System.out.println("Released Lock");
		}
	}

}
