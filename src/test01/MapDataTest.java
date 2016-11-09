package test01;

import net.mindview.util.CountingGenerator;
import net.mindview.util.RandomGenerator;

public class MapDataTest {

	public static void main(String[] args) {
		System.out.println(MapData.map(new Letters(), 11));
		System.out.println(MapData.map(new CountingGenerator.Character(), new RandomGenerator.String(3),8));
		System.out.println(MapData.map(new CountingGenerator.Character(), "Value",6));
		System.out.println(MapData.map(new Letters(), new RandomGenerator.String(3)));
		System.out.println(MapData.map(new Letters(), "Pop"));
	}

}
