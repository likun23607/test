package test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Unsupported {
	static void test(String msg,List<String> list){
		System.out.println("---"+msg+"---");
		Collection<String> c=list;
		Collection<String> subList=list.subList(1, 8);
		
		Collection<String> c2=new ArrayList<String>(subList);
		try{
		c.retainAll(c2);
		}catch(Exception e){
			System.out.println("retailAll():"+e);
		}
		
		try{
			c.removeAll(c2);
			}catch(Exception e){
				System.out.println("removeAll():"+e);
			}
		
	}
	
	public static void main(String[] args) {
		List<String> list=Arrays.asList("A B C D E F G H I J K L".split(" "));
		test("Modifiable Copy",new ArrayList<String>(list));
		test("Arrays.asList()",list);

	}
}
