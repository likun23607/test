package test06enume;

public interface Food {
	enum Appetizer implements Food{
		SALAD,SOUP,SPRING_ROLLS;
	}
	enum MainCourse implements Food{
		LASAGNE,BURRITO,PAD_THAI,
		LENTILS,HUMMOUS,VINDALOO;
	}
	enum Dessert implements Food{
		TIRAMISU,GELATO,BLACK_FOREST_CAKE,
		FRUIT,CREME_CARAMEL;
	}
	enum Coffe implements Food{
		BLACK_COFFEE,DECAF_COFFE,ESPRESSO,
		LATTE,CAPPUCCINO,TEA,HERB_TEA;
	}
}

