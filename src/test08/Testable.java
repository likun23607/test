package test08;

import net.mindview.atunit.Test;

public class Testable {
	public void execute(){
		System.out.println("Executing..");
	}
	@Test void  testExecute(){
		execute();
	}
}
