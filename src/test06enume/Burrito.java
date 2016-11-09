package test06enume;
import static test06enume.Spiciness.*;
public class Burrito {
	
	Spiciness degree;
	public Burrito(Spiciness degree){
		this.degree=degree;
	}
	
	public String toString(){
		return "Burrito is "+degree;
	}
	
	public static void main(String[] args) {
		System.out.println(new Burrito(NOT));
		System.out.println(new Burrito(MILD));
		System.out.println(new Burrito(FLAMING));
		System.out.println(Spiciness.HOT);
		switch (Spiciness.HOT) {
		case HOT:
			
			break;

		default:
			break;
		}
		
	}

}
