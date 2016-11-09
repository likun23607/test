package test01;

import java.util.Iterator;

import net.mindview.util.Generator;
import net.mindview.util.Pair;

public class Letters implements Generator<Pair<Integer,String>>,Iterable<Integer>{

	private int size=9;
	private int number=1;
	private char letter='A';
	
	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer,String>(
				number++,""+letter++
				);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>(){


			@Override
			public Integer next() {
				return number++;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number<size;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
			
		};
	}

}
