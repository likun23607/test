package test08;

import net.mindview.atunit.Test;
import net.mindview.atunit.TestObjectCleanup;

public class AtUnitExample1 {
	public String methodOne(){
		return "this is methodOne";
	}
	public int methodTwo(){
		System.out.println("this is methodTwo");
		return 2;
	}
	
	@TestObjectCleanup
	
	@Test boolean methodOneTest(){
		return methodOne().equals("this is methodOne");
	}
	
	
}
