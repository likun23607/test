package test04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {

	private static final int BSIZE=1024;
	
	
	public static void main(String[] args) throws Exception {
		FileChannel fc=new FileOutputStream("MemoryInput.java").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		fc=new RandomAccessFile("MemoryInput.java", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap(" some more".getBytes()));
		fc.close();
		fc=new FileInputStream("MemoryInput.java").getChannel();
		ByteBuffer buff=ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		while(buff.hasRemaining()){
			System.out.print((char)buff.get());
		}
	}

}
