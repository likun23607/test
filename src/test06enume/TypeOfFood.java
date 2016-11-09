package test06enume;

import test06enume.Food.Appetizer;
import test06enume.Food.Coffe;
import test06enume.Food.Dessert;
import test06enume.Food.MainCourse;

public class TypeOfFood {

	public static void main(String[] args) {
		Food food=Appetizer.SALAD;
		food=MainCourse.LASAGNE;
		food=Dessert.GELATO;
		food=Coffe.CAPPUCCINO;
	}

}
