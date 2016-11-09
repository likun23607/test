package test09Process;

public class DaemonsDonRunFinally {

	public static void main(String[] args) {
		Thread t=new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}

}
