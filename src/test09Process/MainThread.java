package test09Process;

public class MainThread {

	public static void main(String[] args) {
		Thread t=new Thread(new LiftOff());
		t.start();
		System.out.println("waiting for LiftOff");
	}

}
